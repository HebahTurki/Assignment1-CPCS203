import java.util.*;
import java.io.*;
/*
 Name : Hebah Turki Alahmari 
 IDs : 2105304
 Section : BBR
 course name : CPCS203
 Assignment#1
 */

public class BBR_2105304
{
    //calculate the winner of each Criteria for each uni and print it out in the file
    public static void printwinnerAwardByEachCriteria(int[][][] score, String[][] StudentsName, 
            String[] Criteria, String[] uni, PrintWriter out) 
    {
        int winnerScore;
        String winnerName = null;
        for(int i =0; i < Criteria.length; i++)
        {
            for(int j =0; j < uni.length; j++)
            {
                winnerScore = 0;
                for(int k =0; k < StudentsName[j].length; k++)
                {
                    if(winnerScore < score[j][k][i])
                    {
                        winnerScore = score[j][k][i];
                        winnerName = textSplit(StudentsName[j][k]);
                    }
                }
                
                String a = textSplit(uni[j]);
                out.println("\n--- Results of  "+ a +" is as Follows ---");
                String b = textSplit(Criteria[i]);
                out.println(" Contest Winner name in Category:   "+b+" : ");
                out.println(" "+ winnerName);
            }
        }
        out.println();
    }
    //calculate the winner of each Criteria for each uni ends here
    
//--------------------------------------------------------------------------------------------------------
    //print the contest point results in the output file
    public static void printcontestdetailResults(int[][][] score, String[] uni, 
            String[][] StudentsName, String[] Criteria, PrintWriter out) 
    {
        for(int i =0; i < uni.length; i++)
        {
            String a = textSplit(uni[i]);
            out.print("\n---Contest Results of  "+a+" is as Follows ---\n");
            
            for(int j =0; j < StudentsName[i].length; j++)
            {
                String b = textSplit(StudentsName[i][j]);
                out.println("\n---Student Name   " + b + " points  are as Follows ---");
                for (int k =0; k < Criteria.length; k++) 
                {
                    String c = textSplit(Criteria[k]);
                    out.println(" "+c+" : "+score[i][j][k]);
                }
            }
        }
    }
    //print the contest point results in the output file ends here
    
//--------------------------------------------------------------------------------------------------------
    //method to remove "_" from the string
    public static String textSplit(String text) 
    {
        String newText = text.replace("_", " ");
        return newText;
    }
    
//-------------------------------------------------------------------------------------------------------- 
    //print the details of the contest : day, date, the universities. in the output file
    public static void printcontestDetails(String[] uni, String[] day, String[] date, PrintWriter out) 
    {
        out.println("------------------------------------------------------------------------------");
        for(int i =0; i < uni.length; i++)
        {
            String a = textSplit(uni[i]);
            String b = textSplit(date[i]);
            b = b.replace(" ", "/");
            out.printf(" %-30s%-31s%-31s\n",a,day[i],b);
        }
    }
    //print the details of the contest ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add Score to the file
    public static void addScore(int[][][] score, String[][] StudentsName, String[] Criteria, Scanner in) 
    {
        for(int i =0; i < score.length; i++)
        {
            for(int j =0; j < StudentsName[i].length; j++)
            {
                for(int k=0; k < Criteria.length; k++)
                {
                    score[i][j][k] = in.nextInt();
                }
            }
        }
    }
    //Add Score to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add the Award Criteria to the file
    public static void addAwardCriteria(String[] Criteria, Scanner in) 
    {
        for(int i = 0; i < Criteria.length; i++)
        {
            Criteria[i] = in.next();
            
        }
    }
    //Add the Award Criteria to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add Students Name to the file
    public static void addStudentsName(String[][] StudentsName, Scanner in) 
    {
        for(int i = 0; i < StudentsName.length; i++)
        {
            for(int j = 0; j < StudentsName[i].length; j++)
            {
                StudentsName[i][j] = in.next();
            }
        }
    }
    //Add Students Name to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add dates to the file   
    public static void addDates(String[] date, Scanner in) 
    {
        for(int i = 0; i < date.length; i++)
        {
            date[i] = in.next();
            
        }
    }
    //Add dates to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add days to the file 
    public static void addDays(String[] day, Scanner in) 
    {    
        for(int i = 0; i < day.length; i++)
        {
            day[i] = in.next();
            
        }
    }
    //Add days to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    //Add the University to the file 
    public static void addUniversity(String[] uni, Scanner in) 
    {
        for(int i = 0; i < uni.length; i++)
        {
            uni[i] = in.next();
            
        }
    }
    //Add the University to the file ends here
    
//--------------------------------------------------------------------------------------------------------
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Open the input File & reading the data.
        File Fileinput = new File("/Users/hebahturki/NetBeansProjects/BBR_2105304/input.txt");
        
        //Check if the file exists.
        if(!Fileinput.exists())
        {
            System.out.println("Input file does not exist.");
            System.exit(0);
        }
        
        //File pointer to the output file.
        File outputFile = new File("output.txt");
        
        //Make Scanner for input File.
        Scanner BA = new Scanner(Fileinput);
        Scanner BA2 = new Scanner(Fileinput);
        
        //Creating fileWriter to write in the File.
        PrintWriter fileWriter = new PrintWriter(outputFile);
        
        //First read from the input File is the total of university and creating array structure.
        String[] Name_of_university = new String[BA2.nextInt()];
        
        //Second read from the input File is the total of Contest Day and creating array structure.
        String[] ContestDay = new String[BA2.nextInt()];
        
        //Creating array structure for the date of the Contest Day.
        String[] ContestDate = new String[ContestDay.length];
        
        //Creating array structure for Students Name of each university.
        String[][] universityStudentsName = new String[Name_of_university.length][];
        for(int i = 0; i < Name_of_university.length; i++)
        {
            //Creating array structure for total Students Name of each university : King Fahad University, King Khalid University, King Saud University, King AbdulAziz University.
            universityStudentsName[i] = new String[BA2.nextInt()];
        }
        
        //Creating array structure to store Contest Criteria.
        String[] Criteria_of_theContest = new String[BA2.nextInt()];
        
        //Creating array structure to store score record for each Criteria of each student. 
        int[][][] BestAppContestScore = new int[Name_of_university.length][][];
        for(int i = 0; i < universityStudentsName.length; i++)
        {
            BestAppContestScore[i] = new int[universityStudentsName[i].length][Criteria_of_theContest.length];
        }
        
        fileWriter.println("***** Welcome to Best App Winner System *****");
        fileWriter.println("");
        fileWriter.println("------------  Contest App details are as follows ------");
        fileWriter.printf("%-31s%-31s%-31s\n","University Name", "Contest Day", "Contest Date");
        
        String command = null;
        do
        {
            command = BA.next();
            if(command.equalsIgnoreCase("addUniversity"))
            {
                //"addUniversity" is a Command to add university name in the array.
                addUniversity(Name_of_university, BA);
            }
            else if(command.equalsIgnoreCase("addDays"))
            {
                //"addDays" is a command to add Contest Day
                addDays(ContestDay, BA);
            }
            else if(command.equalsIgnoreCase("addDates"))
            {
                //"addDates" is a command to add Contest Date
                addDates(ContestDate, BA);
            }
            else if(command.equalsIgnoreCase("addStudentsName"))
            {
                //"addStudentsName" is a command to add name of the student of each university 
                addStudentsName(universityStudentsName, BA);
            }
            else if(command.equalsIgnoreCase("addAwardCriteria"))
            {
                //"addAwardCriteria" is a command to add the Criteria of the Contest
                addAwardCriteria(Criteria_of_theContest, BA);
            }
            else if(command.equalsIgnoreCase("addScore"))
            {
                //"addScore" is a command to add all the Scores 
                addScore(BestAppContestScore, universityStudentsName, Criteria_of_theContest, BA);
            }
            else if(command.equalsIgnoreCase("printcontestDetails"))
            {
                //"printcontestDetails" is a command to print the contest details in the output file
                printcontestDetails(Name_of_university, ContestDay, ContestDate, fileWriter);
            }
            else if(command.equalsIgnoreCase("printcontestdetailResults"))
            {
                //"printcontestdetailResults" is a command to print the contest results in the output file
                printcontestdetailResults(BestAppContestScore, Name_of_university, universityStudentsName,
                        Criteria_of_theContest, fileWriter);
            }
            else if(command.equalsIgnoreCase("printwinnerAwardByEachCriteria"))
            {
                //"printwinnerAwardByEachCriteria" is a command to print the winner from each uni by each criteria
                printwinnerAwardByEachCriteria(BestAppContestScore, universityStudentsName,
                        Criteria_of_theContest, Name_of_university,  fileWriter);
            }
                    
        }while(!command.equals("Quit"));
        
        fileWriter.print("	Thank you for using Best App Winner System, Good Bye!");
        fileWriter.flush();//save the output in the file 
        fileWriter.close();//close the file writer
        BA.close();//close the file reader
        BA2.close();
    }

}
