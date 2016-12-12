//
//  FourthViewController.swift
//  questionary_app
//
//  Created by Fehime on 10/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var reportResultQ4: String? = " "

class FourthViewController: UIViewController, UITextViewDelegate {

    @IBOutlet weak var question4Label: UILabel!
   
    @IBOutlet weak var commentText: UITextView!
    
    @IBOutlet weak var next4: UIButton!
    
    @IBAction func next4action(_ sender: AnyObject) {
        
        reportResultQ4 = reportResultQ4! + commentText.text
        
    }
    @IBOutlet weak var previous3: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        commentText.text = "Write your comments here"
        
        let url = URL(string: "https://cgi.csc.liv.ac.uk/~phil/COMP327/questionnaire.json")!
        
        let task = URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                print(error)
                
            } else {
                if let urlContent = data {
                    
                    do {
                        let jsonResult = try JSONSerialization.jsonObject(with: urlContent, options: JSONSerialization.ReadingOptions.mutableContainers) as AnyObject

                        
                        if let theQ = ((jsonResult["questions"] as? NSArray)?[3] as? NSDictionary)?["question"] as? String {
                            
                            print("******************fehimeeeeeeeeee")
                            print(theQ)
                            print("******************fehimeeeeeeeeee")
                            
                            self.question4Label.text = String(theQ)
                            
                        }
                        /*if let question1choices = (((jsonResult["questions"] as? NSArray)?[0] as? NSDictionary)?["choices"] as? NSDictionary)?["label"] as?  String {
                         
                         self.q1selextion1.text = question1choices
                         
                         }*/
                        
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
    
    
    func textView(_ textView: UITextView, shouldChangeTextIn range: NSRange, replacementText text: String) -> Bool {
        if range.location + range.length > commentText.text.characters.count {
            return false
        }
        
        let newLength = commentText.text.characters.count + text.characters.count - range.length
        
        return newLength <= 300
    }
   
        
    }


