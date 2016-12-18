//
//  ViewController.swift
//  MyFavouritePlaces
//
//  Created by Fehime on 11/12/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit
import MapKit
//import CoreData

class ViewController: UIViewController, MKMapViewDelegate {

    @IBOutlet weak var map: MKMapView!
    
  //  let appDelegate = UIApplication.shared.delegate as! AppDelegate
  //  var context: NSManagedObjectContext?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        if currentPlace != -1 {
            if places.count > currentPlace {
                if let name = places[currentPlace]["name"] {
                    if let lat = places[currentPlace]["lat"] {
                        if let lon = places[currentPlace]["lon"] {
                            if let latitude = Double(lat) {
                                if let longitude = Double(lon) {
                                    let span = MKCoordinateSpan(latitudeDelta: 0.008, longitudeDelta: 0.008)
                                    let coordinate = CLLocationCoordinate2D(latitude: latitude, longitude: longitude)
                                    let region = MKCoordinateRegion(center: coordinate, span: span)
                                    self.map.setRegion(region, animated: true)
                                    let annotation = MKPointAnnotation()
                                    annotation.coordinate = coordinate
                                    annotation.title = name
                                    self.map.addAnnotation(annotation)
                                } }
                        } }
                } }
        }
        
        let uilpgr = UILongPressGestureRecognizer(target: self, action: #selector(ViewController.longpress(gestureRecognizer:)))
        uilpgr.minimumPressDuration = 2
        map.addGestureRecognizer(uilpgr)
        
        print(currentPlace)
    }
    
    func longpress(gestureRecognizer: UIGestureRecognizer) {
        
       // let context = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
       // let place = Place(context: context)
        
      //  let newPin = NSEntityDescription.insertNewObject(forEntityName: "Place", into: context!)
        
        
        if gestureRecognizer.state == UIGestureRecognizerState.began {
            print("===\nLong Press\n===")
            let touchPoint = gestureRecognizer.location(in: self.map)
            let newCoordinate = self.map.convert(touchPoint, toCoordinateFrom: self.map)
            print(newCoordinate)
            let location = CLLocation(latitude: newCoordinate.latitude, longitude:
                newCoordinate.longitude)
            var title = ""
            CLGeocoder().reverseGeocodeLocation(location, completionHandler:
                { (placemarks, error) in
                    if error != nil {
                        print(error)
                    } else {
                        if let placemark = placemarks?[0] {
                            if placemark.subThoroughfare != nil {
                                title += placemark.subThoroughfare! + " "
                            }
                            if placemark.thoroughfare != nil {
                                title += placemark.thoroughfare!
                            }
                        } }
                    if title == "" {
                        title = "Added \(NSDate())"
                    }
                    let annotation = MKPointAnnotation()
                    annotation.coordinate = newCoordinate
                    annotation.title = title
                    self.map.addAnnotation(annotation)
                    places.append(["name":title, "lat": String(newCoordinate.latitude),
                                   "lon": String(newCoordinate.longitude)])
                    
                  //  UserDefaults.standard.set(title, forKey: "name")
                    //UserDefaults.standard.set(String(newCoordinate.latitude), forKey: "lat")
                    //UserDefaults.standard.set(String(newCoordinate.longitude), forKey: "lon")

                   
                   // place.name = title
                   // place.lat = String(newCoordinate.longitude)
                   // place.lon = String(newCoordinate.longitude)
                    
                    //(UIApplication.shared.delegate as! AppDelegate).saveContext()
                    
                   /*
                    newPin.setValue(title, forKey: "name")
                    newPin.setValue(String(newCoordinate.latitude), forKey: "lat")
                    newPin.setValue(String(newCoordinate.longitude), forKey: "lon")
                    
                    do {
                        try self.context?.save()
                        
                        print("Saved")
                        
                        
                    } catch {
                        print("there was an error")
                    }
                     */

                    
            }) }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

