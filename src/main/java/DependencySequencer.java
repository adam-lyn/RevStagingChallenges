import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DependencySequencer {

    public void DependencySequencer(String projects, char[][] dependencies, ArrayList<Character> myList) throws Exception {
        int count = 0;
        while(myList.size() != projects.length()){
            for (int i = 0; i < projects.length(); i++){
                boolean flag = true;
                // If already exists, skip
                if (myList.contains(projects.charAt(i)))
                    continue;
                for (int j = 0; j < dependencies.length; j++){
                    if (projects.charAt(i) == dependencies[j][1] && !myList.contains(dependencies[j][0])){
                        flag = false;
                    }

                }
                if (flag)
                    myList.add(projects.charAt(i));

            }
            count++;
            if(count == projects.length()*2)
                throw new Exception("Build Error: No valid build order");
        }
    }

    public static void main(String[] args) throws Exception {
        String projects = ("a b c d e f");
        String trimmedProjects = projects.replaceAll(" ", "");
        char[][] dependencies = {{'a','d'}, {'f','b'}, {'b','d'}, {'f','a'}, {'d','c'}};
        ArrayList<Character> myList = new ArrayList<>();
        DependencySequencer solution = new DependencySequencer();
        solution.DependencySequencer(trimmedProjects, dependencies, myList);

        //Acceptable Outputs
        // f, e, a, b, d, c
        // e, f, a, b, d, c
        System.out.println(myList);
    }
}

