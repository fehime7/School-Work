//
//  PlaceDetailsViewController.swift
//  LocationOfPlaces
//
//  Created by Fehime on 15/12/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

class PlaceDetailsViewController: UIViewController {
    
    @IBOutlet weak var placeImage: UIImageView!
    
    @IBOutlet weak var placeInfo: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
       placeInfo.text = infoString

        /*
        
        let url = URL(string: "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=53.406566,%20-2.966531&radius=500&type=store&keyword=\(searchEntry)&key=%20AIzaSyD_SvOcCekOkV67k4TGtw-7Q8gMS4KUPfU")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                print("boooooooooooooooooooooooooooooooooooooooooooooooooooooooook")
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject
                        
                        
                        if let theQ = ((jsonResult["results"] as? NSArray)?[0] as? NSDictionary)? ["name"] as? String {
                            
                            print("******************fehimeeeeeeeeee")
                            print(theQ)
                            print("******************fehimeeeeeeeeee")
                            self.placeInfo.text = String(theQ)
                            
                        }
                        if let theQ2 = ((jsonResult["results"] as? NSArray)?[0] as? NSDictionary)? ["icon"] as? String {
                           
                            let imageURL = NSURL(string: theQ2)
                            if let imageData = NSData(contentsOf: imageURL as! URL){
                                self.placeImage.image = UIImage(data: imageData as Data)
                            }
                           
                            
                        }
                        
                        
                        
                    } catch {
                        print("======\nJSON processing Failed\n=======")
                    }
                    
                }
            }
        }
        
        task.resume()
    */
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
