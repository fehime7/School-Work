//
//  ViewController.swift
//  TableView
//
//  Created by Fehime on 20/10/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var inputNumber: UITextField!
    
    @IBOutlet weak var numberTable: UITableView!
  
    @IBAction func goButton(_ sender: AnyObject)  {
        
        for i in 1 ..< 21 {
            numbers.append(i)
        }
        numberTable.reloadData()
   
    }
    
    var numbers : [Int] = []
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //let rowNumber = Int((inputNumber.text)!)
        
        return numbers.count
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var num = Int(inputNumber.text!)
        
        
        let cell = UITableViewCell(style: UITableViewCellStyle.default, reuseIdentifier: "myCell")
        cell.textLabel?.text = String(numbers[indexPath.row]) + " x \(num!) = \(numbers[indexPath.row]*num!)"
        
        
        return cell
    }
    
    public func tableView(tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        return tableView.dequeueReusableHeaderFooterView(withIdentifier: "goButton")
    }
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        numberTable.delegate=self
        numberTable.dataSource=self
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

