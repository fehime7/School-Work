//
//  ViewController.swift
//  Simple Login
//
//  Created by Phil Jimmieson on 16/10/2016.
//  Copyright © 2016 Phil Jimmieson. All rights reserved.
//

import UIKit
import CoreData

class ViewController: UIViewController {
    
    @IBOutlet weak var username: UITextField!
    
    @IBOutlet weak var password: UILabel!
    
    @IBOutlet weak var welcomMessage: UILabel!
    
    @IBOutlet weak var loginBtn: UIButton!
    
    @IBOutlet weak var logoutButton: UIButton!
    
    
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    var context: NSManagedObjectContext?
    
    
    @IBAction func login(_ sender: AnyObject) {
        let newUser = NSEntityDescription.insertNewObject(forEntityName: "Logins", into: context!)
        newUser.setValue(username.text, forKey: "username")
        newUser.setValue(password.text, forKey: "password")
        
        do {
            try context?.save()
            
            print("Saved")
            welcomMessage.text = "Your info has been saved"
            welcomMessage.isHidden = false
            username.isHidden = true
            password.isHidden = true
            loginBtn.isHidden = true
            
        } catch {
            print("there was an error")
        }
    }
    

    
    @IBAction func logout(_ sender: AnyObject) {
        //setup request
        //setup predicate
        //try to retrieve the results
        //use context?.delete(   )  to remove the item
        //don't forget to try to save everything
        
        //make the appropriate bits of your UI show up
        let logoutrequest = NSFetchRequest<NSFetchRequestResult>(entityName: "Logins")
        
        logoutrequest.predicate = NSPredicate(format: "username <> %@", "") //look for username=a string, where the string is not empty.
        
        logoutrequest.returnsObjectsAsFaults = false
        
        do {
            let results = try context?.fetch(logoutrequest)
            
            if (results?.count)! > 0 {
                
                let result = results?[(results?.count)!-1] as! NSManagedObject
                
                if let theUsername = result.value(forKey: "username") as? String {
                    welcomMessage.text = "\(theUsername) logged out"
                    welcomMessage.isHidden = false
                    username.isHidden = false
                    password.isHidden = false
                    loginBtn.isHidden = false
                    logoutButton.isHidden = true
                    context?.delete(results?[(results?.count)!-1] as! NSManagedObject)
                    print(result)
                    print(results?.count)

                }
            } else {
                print("No results")
                welcomMessage.isHidden = true
                username.isHidden = false
                password.isHidden = false
                loginBtn.isHidden = false
                logoutButton.isHidden = true
            }
        } catch {
            print("Couldn't fetch results")
        }

        
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        context = appDelegate.persistentContainer.viewContext
        
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Logins")
        
        request.predicate = NSPredicate(format: "username <> %@", "") //look for username=a string, where the string is not empty.
        
        request.returnsObjectsAsFaults = false
        welcomMessage.isHidden = true
        
        do {
            let results = try context?.fetch(request)
            
            if (results?.count)! > 0 {
                
                let result = results?[(results?.count)! - 1] as! NSManagedObject
                
                    if let theUsername = result.value(forKey: "username") as? String {
                        welcomMessage.text = "Welcome, \(theUsername)"
                        welcomMessage.isHidden = false
                        username.isHidden = true
                        password.isHidden = true
                        loginBtn.isHidden = true
                        logoutButton.isHidden = false
                    }
            } else {
                print("No results")
                welcomMessage.isHidden = true
                username.isHidden = false
                password.isHidden = false
                loginBtn.isHidden = false
                logoutButton.isHidden = true
            }
        } catch {
            print("Couldn't fetch results")
        }
  
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}

