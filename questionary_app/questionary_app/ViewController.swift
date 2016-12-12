//
//  ViewController.swift
//  questionary_app
//
//  Created by Fehime on 09/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var reportResultQ1: String?
var answer: Int = 5
var answerTotal: Int = 0

class ViewController: UIViewController {
   
   
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var question1Label: UILabel!
    
    @IBOutlet weak var answerLabel: UILabel!
    
    
    @IBOutlet weak var q1selextion1: UILabel!
    
    @IBOutlet weak var q1selection2: UILabel!
    
    @IBOutlet weak var q1selection3: UILabel!
    
    @IBOutlet weak var q1selection4: UILabel!
    
    @IBOutlet weak var q1selection5: UILabel!
    
    @IBAction func decreaseButton(_ sender: AnyObject) {
        if answer > 1  {
            answer = answer - 1
            answerLabel.text = String(answer)
        }
        
    }
    @IBAction func increaseButton(_ sender: AnyObject) {
        if answer < 5  {
            answer = answer + 1
            answerLabel.text = String(answer)
        }
        
    }
    
    @IBAction func next1(_ sender: AnyObject) {
        
        reportResultQ1 = answerLabel.text
        answerTotal = answerTotal + answer
        
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        
        let url = URL(string: "https://cgi.csc.liv.ac.uk/~phil/COMP327/questionnaire.json")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject
                        
                        
                        if let theQ = ((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["question"] as? String {
                            
                            print(theQ)

                            self.question1Label.text = String(theQ)
                            
                            
                        }
                       
                        if let question1choices = ((((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSArray)?[0] as? NSDictionary)?["label"] as? String {
                            
                            self.q1selextion1.text = "1-" + question1choices
                            
                        }
                        if let question1choices2 = ((((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSArray)?[1] as? NSDictionary)?["label"] as? String {
                            
                            self.q1selection2.text = "2-" + question1choices2
                            
                        }
                        if let question1choices3 = ((((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSArray)?[2] as? NSDictionary)?["label"] as? String {
                            
                            self.q1selection3.text = "3-" + question1choices3
                            
                        }
                        if let question1choices4 = ((((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSArray)?[3] as? NSDictionary)?["label"] as? String {
                            
                            self.q1selection4.text = "4-" + question1choices4
                            
                        }


                        if let question1choices5 = ((((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSArray)?[4] as? NSDictionary)?["label"] as? String {
                            
                            self.q1selection5.text = "5-" + question1choices5
                            
                        }


                        if let theQ2 = jsonResult["title"] as? String
                        {
                            print(theQ2)
                            self.titleLabel.text = String(theQ2)
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

}

