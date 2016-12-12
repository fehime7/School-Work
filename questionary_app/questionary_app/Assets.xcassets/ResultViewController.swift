//
//  ResultViewController.swift
//  questionary_app
//
//  Created by Fehime on 10/11/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit
var countTester: Int = 0

class ResultViewController: UIViewController {

    @IBOutlet weak var resultText: UITextView!
    
    @IBOutlet weak var resultHeather: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        
        countTester = countTester + 1
        print(countTester)
        // Do any additional setup after loading the view.
        
        resultText.text = "\n1- Average happiness out of 5: \(answerTotal/countTester).\n2- Students attended lectures on average: \(answer2total/countTester).\n3- Average number of mobile devices: \(totalDevice/countTester) \n4- Comments: " + reportResultQ4!
        
        
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
