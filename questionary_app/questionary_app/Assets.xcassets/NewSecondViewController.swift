//
//  NewSecondViewController.swift
//  questionary_app
//
//  Created by Fehime on 11/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var newReportResultQ2: Int = 0
var answer2total: Int = 0

class NewSecondViewController: UIViewController {
    
    
    @IBOutlet weak var question2label: UILabel!
    
    @IBOutlet weak var switch1: UISwitch!
    
    @IBOutlet weak var switch2: UISwitch!
    
    @IBOutlet weak var switch3: UISwitch!

    @IBOutlet weak var switch4: UISwitch!
    
    @IBOutlet weak var option1label: UILabel!
    
    @IBOutlet weak var option2label: UILabel!
    
    @IBOutlet weak var option3label: UILabel!
    
    @IBOutlet weak var option4label: UILabel!
    
    @IBAction func next2(_ sender: AnyObject) {
        
        if switch1.isOn {
            newReportResultQ2 = newReportResultQ2 + 1
        }
        if switch2.isOn {
            newReportResultQ2 = newReportResultQ2 + 1
        }
        if switch3.isOn {
            newReportResultQ2 = newReportResultQ2 + 1
        }
        if switch4.isOn {
            newReportResultQ2 = newReportResultQ2 + 1
        }
        answer2total = answer2total + newReportResultQ2
        
    }
    
    @IBAction func previous1(_ sender: AnyObject) {
        answerTotal = 0
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
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
                        
                        if let theQ = ((jsonResult["questions"] as? NSArray)?[1] as? NSDictionary)?["question"] as? String {
                            print("******************fehimeeeeeeeeee")
                            
                            print(theQ)
                            print("******************fehimeeeeeeeeee")
                            
                            self.question2label.text = theQ
                            
                        }
                        if let question2choices = ((((jsonResult["questions"] as? NSArray)?[1] as? NSDictionary)?["choices"] as? NSArray)?[0] as? NSDictionary)?["label"] as? String {
                            
                            self.option1label.text = question2choices
                            
                        }
                        if let question2choices2 = ((((jsonResult["questions"] as? NSArray)?[1] as? NSDictionary)?["choices"] as? NSArray)?[1] as? NSDictionary)?["label"] as? String {
                            
                            self.option2label.text = question2choices2
                            
                        }
                        if let question2choices3 = ((((jsonResult["questions"] as? NSArray)?[1] as? NSDictionary)?["choices"] as? NSArray)?[2] as? NSDictionary)?["label"] as? String {
                            
                            self.option3label.text = question2choices3
                            
                        }
                        if let question2choices4 = ((((jsonResult["questions"] as? NSArray)?[1] as? NSDictionary)?["choices"] as? NSArray)?[3] as? NSDictionary)?["label"] as? String {
                            
                            self.option4label.text = question2choices4
                            
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
