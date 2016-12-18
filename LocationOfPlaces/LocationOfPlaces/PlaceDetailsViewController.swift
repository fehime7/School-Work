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

    @IBOutlet weak var addressLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        placeInfo.text = infoString
        addressLabel.text = addressString
        let imageURL = NSURL(string: imageString)
        if let imageData = NSData(contentsOf: imageURL as! URL){
            self.placeImage.image = UIImage(data: imageData as Data)
        }
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
