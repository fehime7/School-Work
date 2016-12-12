//
//  ThirdViewController.swift
//  questionary_app
//
//  Created by Fehime on 09/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var reportResultQ3: String?
var totalDevice: Int = 0

class ThirdViewController: UIViewController {

   
    @IBOutlet weak var question3label: UILabel!
    
    @IBOutlet weak var answerL: UILabel!
    
   // @IBOutlet weak var sliderOutlet: UISlider!
    
   // @IBAction func sliderAction(_ sender: AnyObject) {
        //answerL.text = String(Int(sliderOutlet.value))
        
    //}
    
    
    @IBOutlet weak var sliderOutler: UISlider!
    
    
    @IBAction func sliderAct(_ sender: UISlider) {
        
        let currentValue:String = String(Int(sender.value))
        
        answerL.text = currentValue
    }
    
    @IBAction func next3(_ sender: AnyObject) {
        
        reportResultQ3 = answerL.text
        totalDevice = totalDevice + Int(sliderOutler.value)
        
    }
    
    @IBAction func previous2(_ sender: AnyObject) {
        newReportResultQ2=0
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
         //answerL.text = String(Int(sliderOutlet.value))
        
        let url = URL(string: "https://cgi.csc.liv.ac.uk/~phil/COMP327/questionnaire.json")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
               
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject
                        
                        //print(jsonResult)
                        
                        //print(jsonResult["description"]!!)
                        
                        if let theQ = ((jsonResult["questions"] as? NSArray)?[2] as? NSDictionary)?["question"] as? String {
                            
                            print("******************fehimeeeeeeeeee")
                            print(theQ)
                            print("******************fehimeeeeeeeeee")
                            
                            self.question3label.text = String(theQ)
                            
                        }
                       
                        
                    } catch {
                        print("======\nJSON processing Failed\n=======")
                    }
                    
                }
            }
        }
        
        task.resume()


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
