//
//  PlacesTableViewController.swift
//  MyFavouritePlaces
//
//  Created by Fehime on 12/12/16.
//  Copyright © 2016 Fehime. All rights reserved.
//

import UIKit

var currentPlace = -1

var places = [Dictionary<String, String>()]

var places2 : [Place] = []

//var tablePlaces = [NSManagedObject]()

class PlacesViewController: UITableViewController {
    
    @IBOutlet var table: UITableView!
    
    @IBOutlet weak var barItem: UIBarButtonItem!
    
    @IBAction func addItem(_ sender: AnyObject) {
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        
        return places.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
   
        let cell = UITableViewCell(style: UITableViewCellStyle.default, reuseIdentifier: "Cell")
       
        if places[indexPath.row]["name"] != nil {
            cell.textLabel?.text = places[indexPath.row]["name"]
        }
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        currentPlace = indexPath.row
        
        performSegue(withIdentifier: "to Map", sender: nil)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        if places.count == 1 && places[0].count == 0 {
            places.remove(at: 0)
            places.append(["name":"Ashton Building", "lat": "53.406566", "lon": "-2.966531"])
        }
        
        //currentPlace = -1
        table.reloadData()
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
    
            places.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: UITableViewRowAnimation.automatic)
        }
        table.reloadData()
    }
    

    
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to toIndexPath: IndexPath)
     {
        var itemToMove = places[fromIndexPath.row]
        places.remove(at: fromIndexPath.row)
        places.insert(itemToMove, at: toIndexPath.row)
        table.reloadData()

    }
    

    
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
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
