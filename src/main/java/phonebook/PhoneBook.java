package phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>(map);
    }
    public PhoneBook(){
        this(new LinkedHashMap<>());

    }

    /**
     * look to see if name is already there
     * if it does then add phone number to the value
     * (else)create a new array list and associate it with the key n add phone # to the list
     * you cant have without a key without value (vise versa)
     * @param name
     * @param phoneNumber
     */
    public void add(String name, String phoneNumber) {
       if (phonebook.containsKey(name)) { // check to see if it contains name/key
           List<String> phoneNumbers = phonebook.get(name); //holding numbers that accociated with the name
           phoneNumbers.add(phoneNumber); // adding phone numbers to list
       }else { // if the map does not contain the name/key
           List<String> phoneNumbers = new ArrayList<>(); // creating a new array of phone numbers/values to add to the name/key
           phoneNumbers.add(phoneNumber); // adding phone number/value to arraylist
           phonebook.put(name,phoneNumbers); // adding another entry to the map.
       }

    }

    public void addAll(String name, String... phoneNumbers) {
       // List<String> phoneNumber = new ArrayList<>();
        if(phonebook.containsKey(name)) {
            List<String> phoneNumber = phonebook.get(name);
            for (String number : phoneNumbers) {
                phoneNumber.add(number);
            }
        }else{
            List<String> phoneNumberList = new ArrayList<>();
            for (String number : phoneNumbers) {
                phoneNumberList.add(number);
            }
                phonebook.put(name, phoneNumberList);



        }


    }

    public void remove(String name) {
        if (phonebook.containsKey(name)){
            phonebook.remove(name);

        }else{
            System.out.println("This name is not in your contact List");
        }

    }

    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)) {
            System.out.println(name + " Is in your contact list");
        }
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        }else{
            System.out.println("Name does not exist ");
            return null;
        }
    }

    /**
     *return the phone number/value associated with the name/key
     * use for loop to look each entry inside a hashmap
     * loop thru given name/key and access the phone numbers/value
     * @param phoneNumber
     * @return
     */
    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            List<String> numbers = entry.getValue();
            if (numbers.contains(phoneNumber)){
                return entry.getKey();
            }else {
                System.out.println("This number is not in your contact list");
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {

        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
