//
//  SecondViewController.swift
//  questionary_app
//
//  Created by Fehime on 09/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var reportResultQ2: Int = 0

class SecondViewController: UIViewController {

    @IBOutlet weak var question2Label: UILabel!
    
    @IBOutlet weak var switch1: UISwitch!
    
    @IBOutlet weak var switch2: UISwitch!
    
    @IBOutlet weak var switch3: UISwitch!
    
    @IBOutlet weak var switch4: UISwitch!
    
    @IBOutlet weak var q2selection1: UILabel!
    
    @IBOutlet weak var q2selection2: UILabel!
    
    @IBOutlet weak var q2selection3: UILabel!
    
    @IBOutlet weak var q2selection4: UILabel!
    
    @IBAction func previous1(_ sender: UIButton) {
       
        
    }
    
    @IBAction func next2(_ sender: AnyObject) {
        
        if switch1.isOn {
            reportResultQ2 = reportResultQ2 + 1
        }
        if switch2.isOn {
            reportResultQ2 = reportResultQ2 + 1
        }
        if switch3.isOn {
            reportResultQ2 = reportResultQ2 + 1
        }
        if switch4.isOn {
            reportResultQ2 = reportResultQ2 + 1
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        let url = URL(string: "https://cgi.csc.liv.ac.uk/~phil/COMP327/questionnaire.json")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                print("******************fehimeeeeeeeeee")
                
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
                            
                            self.question2Label.text = theQ
                            
                            
                            
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
