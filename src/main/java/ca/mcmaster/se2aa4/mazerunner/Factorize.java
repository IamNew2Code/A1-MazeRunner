package ca.mcmaster.se2aa4.mazerunner;

public class Factorize {
    public String factorizePath(String calculatedPath){
        StringBuilder factorizedPath = new StringBuilder();
        int count = 0;

        for(char c: calculatedPath.toCharArray()){
            //keep raising the counter of F if we keep on encountering them
            if(c == 'F'){
                count++;
            } else{                 //if we do not encounter any more Fs then append the total amount of F found first
                if(count > 0){      //then append the other directio R or L afterwards and reset count to 0
                    factorizedPath.append(count).append('F');
                    count = 0;
                }
            }
        }

        //checks if the path has Fs at the end if so then we need to append them
        if (count > 0){
            factorizedPath.append(count).append('F');
        }

        return factorizedPath.toString();
    }
}
