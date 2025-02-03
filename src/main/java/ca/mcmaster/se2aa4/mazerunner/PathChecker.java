package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {
    private String inputPath;
    private String calculatedPath;
    private boolean isFactorized;
    
    public PathChecker(String inputPath, String calcuatedPath){
        this.inputPath = inputPath;
        this.calculatedPath = calcuatedPath;
    }

    public void checkCanOrFact(){
        
        for(char c: this.inputPath.toCharArray()){
            if(Character.isDigit(c)){
                this.isFactorized = true;
                break;
            } else {
                this.isFactorized = false;
                break;
            }
        }
    }

    public void formatInput(){

        if(this.isFactorized == true){
            StringBuilder reformatedInput = new StringBuilder();
            char[] temp = this.inputPath.toCharArray();

            for(int i = 0; i<temp.length; i++){
                if(Character.isDigit(temp[i])){
                    int repeatCount = Character.getNumericValue(temp[i]);
                    char charToRepeat = temp[i+1];

                    for(int j = 0; j<repeatCount-1; j++){
                        reformatedInput.append(charToRepeat);
                    }
                } else{
                    reformatedInput.append(temp[i]);
                }
            }
            this.inputPath = reformatedInput.toString();

        } else if (this.isFactorized == false){
            this.inputPath = this.inputPath.replaceAll("\\s+", "");
        }
    }

    public String checkPath(){

        if(this.calculatedPath.equals(this.inputPath)){
            return "correct path";
        } else{
            return "incorrect path";
        }
    }
}
