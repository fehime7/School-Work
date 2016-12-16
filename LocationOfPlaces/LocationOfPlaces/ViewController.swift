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

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    var locationManager = CLLocationManager()
    
    var currentPlace = 0
    
    var places = [Dictionary<String, String>()]
  

    @IBOutlet weak var map: MKMapView!
    
    @IBOutlet weak var table: UITableView!
    
    
    @IBAction func search(_ sender: AnyObject) {
        
        let alert = UIAlertController(title: "Place Filter",
                                      message: "Write the specific type for places",
                                      preferredStyle: .alert)
        
        let searchAction = UIAlertAction(title: "Search",
                                       style: .default,
                                       handler: { (action:UIAlertAction) -> Void in
                                        
                                        let textField = alert.textFields!.first
                                        searchEntry = textField!.text!
                                        print(searchEntry)
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
      
        /*
        places.remove(at: 0)
        places.append(["name":"Ashton Building", "lat": "53.406566", "lon": "-2.966531"])
        
        let name = places[currentPlace]["name"]
        let latitude = Double(places[currentPlace]["lat"]!)!
        let longitude = Double(places[currentPlace]["lon"]!)!
        
        //let latitude = 53.406566
        //let longitude = -2.966531
        
        let span = MKCoordinateSpan(latitudeDelta: 0.008, longitudeDelta: 0.008)
        let coordinate = CLLocationCoordinate2D(latitude: latitude , longitude: longitude)
        let region = MKCoordinateRegion(center: coordinate, span: span)
        self.map.setRegion(region, animated: true)
        let annotation = MKPointAnnotation()
        annotation.coordinate = coordinate
        annotation.title = name
        self.map.addAnnotation(annotation)
*/

    }
    
    override func viewDidAppear(_ animated: Bool) {
        if places.count == 1 && places[0].count == 0 {
            places.remove(at: 0)
            places.append(["name":"Ashton Building", "lat": "53.406566", "lon": "-2.966531"])
        }
    
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
        currentPlace = indexPath.row
        
        performSegue(withIdentifier: "to Details", sender: nil)
    }
    

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
        let latitude = 53.406566
        let longitude = -2.966531
        let span = MKCoordinateSpanMake(0.008, 0.008)
        let region = MKCoordinateRegion(center: location.coordinate, span: span)
        map.setRegion(region, animated: true)
        let coordinate = CLLocationCoordinate2D(latitude: latitude , longitude: longitude)
        let annotation = MKPointAnnotation()
        annotation.coordinate = coordinate
        self.map.addAnnotation(annotation)
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("error:: \(error)")
    }
    
}






