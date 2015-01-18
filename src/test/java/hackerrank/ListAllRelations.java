package hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by devesh on 1/17/15.
 */
public class ListAllRelations {
    
    public Map<String, Set<String>> netWork = new HashMap<String, Set<String>>();
    
    @Before
    public void setUp() throws Exception{
        String [] lines = {
                "J I",
                "B A",
                "C A",
                "D C",
                "E B",
                "F A",
                "G B",
                "H F",
                "I H",
                "J H"
        };

        for(String str : lines){
            String [] arr = str.split(" ");
            addToNetwork(arr[0], arr[1]);
            addToNetwork(arr[1], arr[0]);
        }
        
    }

    void addToNetwork(String a, String b){
        Set<String> person = netWork.get(a);
        if(person== null)
            person = new HashSet<String>();
        person.add(b);
        netWork.put(a, person);
    }

    List<String> getAllContacts(String a){
        List<String> result = new ArrayList<String>();

        Set<String> contacts = netWork.get(a);
        result.addAll(contacts);

        return result;
    }
    
    @Test
    public void testAllRelations() throws Exception{
        String root = "A";
        Map<Integer, List<String>> result = new HashMap<Integer, List<String>>();
        List<String> first = new ArrayList<String>();
        first.add(root);
        result.put(0, first);
        int currLevel = 0;
        while(true){
            List<String> currentContacts = result.get(currLevel);
            List<String> contactsToAdd = new ArrayList<String>();
            for(String contact: currentContacts){
                List<String> relations = getAllContacts(contact);
                contactsToAdd.addAll(relations);
            }
            for(Integer i: result.keySet())
                contactsToAdd.removeAll(result.get(i));


            if(contactsToAdd.isEmpty()){
                break;
            }


            currLevel++;
            result.put(currLevel, contactsToAdd);
        }

        System.out.println(result.toString());
    }
}
