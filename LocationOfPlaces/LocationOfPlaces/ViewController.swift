//
//  ViewController.swift
//  LocationOfPlaces
//
//  Created by Fehime on 15/12/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit
import MapKit

var searchEntry = ""
var filterentry = ""
var selection = -1
var control = 0
var imageString = ""
var addressString = ""
var infoString = ""

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    var locationManager = CLLocationManager()
    var places = [Dictionary<String, String>()]
  
    @IBOutlet weak var map: MKMapView!
    
    @IBOutlet weak var table: UITableView!
    
    @IBAction func filter(_ sender: AnyObject) {
        
        control = 2
        
        let alert2 = UIAlertController(title: "Filter ",
                                       message: "Write the specific key for places",
                                       preferredStyle: .alert)
        
        let filterAction = UIAlertAction(title: "Filter",
                                         style: .default,
                                         handler: { (action:UIAlertAction) -> Void in
                                            
                                            let textField = alert2.textFields!.first
                                            filterentry = textField!.text!
                                            self.apiFilter()
                                            self.table.reloadData()
        })
        
        let cancelAction = UIAlertAction(title: "Cancel",
                                         style: .default) { (action: UIAlertAction) -> Void in
        }
        
        alert2.addTextField {
            (textField: UITextField) -> Void in
        }
        
        alert2.addAction(filterAction)
        alert2.addAction(cancelAction)
        
        present(alert2, animated: true, completion: nil)
    }
    
    @IBAction func search(_ sender: AnyObject) {
        
        control = 1
        
        let alert = UIAlertController(title: "Place Search",
                                      message: "Write the specific type for places",
                                      preferredStyle: .alert)
        
        let searchAction = UIAlertAction(title: "Search",
                                       style: .default,
                                       handler: { (action:UIAlertAction) -> Void in
                                        
                                        let textField = alert.textFields!.first
                                        searchEntry = textField!.text!
                                        print(searchEntry)
                                        self.apiConnection()
                                        self.table.reloadData()
        })
        
        let cancelAction = UIAlertAction(title: "Cancel",
                                         style: .default) { (action: UIAlertAction) -> Void in
        }
        
        alert.addTextField {
            (textField: UITextField) -> Void in
        }
        
        alert.addAction(searchAction)
        alert.addAction(cancelAction)
        
        present(alert, animated: true, completion: nil)
        
        
    }
    
    private func apiConnection(){
        
        if places.count == 1 && places[0].count == 0 {
            places.remove(at: 0)
        }

        
        let url = URL(string: "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=53.406566,%20-2.966531&radius=1000&type=\(searchEntry)&keyword=establishment&key=AIzaSyDTh2Pj5a3p2f5fjWXRg8rpOWraXd9VDiU")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject
                       
                       
                        if let firstArray = jsonResult["results"] as? NSArray {
                             for i in 0...firstArray.count/2{
                                if let secondArray = (firstArray[i] as? NSDictionary) {
                                    let name = secondArray["name"] as? String
                                    let vicinity = secondArray["vicinity"] as? String
                                    let icon = secondArray["icon"] as? String
                                    let rating = secondArray["rating"] as? Double
                                    
                                    let lat2 = (secondArray["geometry"] as? NSDictionary)
                                    let lat1 = lat2?["location"] as? NSDictionary
                                    let lat = lat1?["lat"] as? Double
                                    
                                    let lon2 = (secondArray["geometry"] as? NSDictionary)
                                    let lon1 = lon2?["location"] as? NSDictionary
                                    let lon = lon1?["lng"] as? Double
                                    
                                    self.places.append(["name": name!, "vicinity": vicinity!, "icon": icon!])
                                    print(self.places)
                                    self.table.reloadData()
                                    
                                    let coordinate = CLLocationCoordinate2D(latitude: lat! , longitude: lon!)
                                    let annotation = MKPointAnnotation()
                                    annotation.coordinate = coordinate
                                    self.map.addAnnotation(annotation)
                                    annotation.title = name
                                    self.table.reloadData()
 
                                }
                            }
                        }
                        
    
                    } catch {
                        print("======\nJSON processing Failed\n=======")
                    }
                    
                }
            }
        }
        
        task.resume()
        
    }
    
    
    private func apiFilter()  {
        
        places.remove(at: 0)
        
        let url = URL(string: "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=53.406566,%20-2.966531&radius=1000&type=\(searchEntry)&keyword=\(filterentry)&key=AIzaSyDTh2Pj5a3p2f5fjWXRg8rpOWraXd9VDiU")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject
                        
                        if let firstArray = jsonResult["results"] as? NSArray {
                            for i in 0...firstArray.count-1{
                                if let secondArray = (firstArray[i] as? NSDictionary) {
                                    let name = secondArray["name"] as? String
                                    let vicinity = secondArray["vicinity"] as? String
                                    let icon = secondArray["icon"] as? String
                                    let rating = secondArray["rating"] as? Double
                        
                                    
                                    let lat2 = (secondArray["geometry"] as? NSDictionary)
                                    let lat1 = lat2?["location"] as? NSDictionary
                                    let lat = lat1?["lat"] as? Double
                                    
                                    let lon2 = (secondArray["geometry"] as? NSDictionary)
                                    let lon1 = lon2?["location"] as? NSDictionary
                                    let lon = lon1?["lng"] as? Double
                                    
                                    self.places.append(["name": name!, "vicinity": vicinity!, "icon": icon!])
                                    print(self.places)
                                    self.table.reloadData()
                                    
                                    let coordinate = CLLocationCoordinate2D(latitude: lat! , longitude: lon!)
                                    let annotation = MKPointAnnotation()
                                    annotation.coordinate = coordinate
                                    self.map.addAnnotation(annotation)
                                    annotation.title = name
                                    self.table.reloadData()
                                    
                                }
                            }
                        }
                        
                    } catch {
                        print("======\nJSON processing Failed\n=======")
                    }
                    
                }
            }
        }
        
        task.resume()

        
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        table.delegate = self
        table.dataSource = self
        
        if (CLLocationManager.locationServicesEnabled())
        {
            locationManager = CLLocationManager()
            locationManager.delegate = self
            locationManager.desiredAccuracy = kCLLocationAccuracyBest
            locationManager.requestAlwaysAuthorization()
            locationManager.startUpdatingLocation()
            
        }
        
        let latitude = 53.406566
        let longitude = -2.966531
        let coordinate = CLLocationCoordinate2D(latitude: latitude , longitude: longitude)
        let annotation = MKPointAnnotation()
        annotation.coordinate = coordinate
        annotation.title = "You are here!"
        self.map.addAnnotation(annotation)

    }
    
    
    override func viewDidAppear(_ animated: Bool) {
        if control == 1 {
            apiConnection()
        }
        if control == 2 {
            apiFilter()
        }
        print(places)
        table.reloadData()
    }
 
 
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
 
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return places.count
    }
    
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = UITableViewCell(style: UITableViewCellStyle.default, reuseIdentifier: "Cell")
        
        if places[indexPath.row]["name"] != nil {
            cell.textLabel?.text = places[indexPath.row]["name"]
        }
        return cell
    }
    
    public func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        selection = indexPath.row
        infoString = places[selection]["name"]! 
        addressString = places[selection]["vicinity"]!
        imageString = places[selection]["icon"]!
        
        performSegue(withIdentifier: "to Details", sender: nil)
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            places.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: UITableViewRowAnimation.automatic)
        }
        table.reloadData()
    }
    
   
    /*
    public func tableView(tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        return tableView.dequeueReusableHeaderFooterView(withIdentifier: "search")
    }*/
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}


extension ViewController : CLLocationManagerDelegate {
    
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        if status == .authorizedWhenInUse {
            locationManager.requestLocation()
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let location = locations.first else { return }
        let span = MKCoordinateSpanMake(0.02, 0.02)
        let region = MKCoordinateRegion(center: location.coordinate, span: span)
        map.setRegion(region, animated: true)
        
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("error:: \(error)")
    }
    
}






