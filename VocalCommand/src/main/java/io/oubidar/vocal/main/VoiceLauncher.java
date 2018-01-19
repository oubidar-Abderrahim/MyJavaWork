package io.oubidar.vocal.main;

//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Abderrahim OUBIDAR
 */
public class VoiceLauncher {
  public static void main(String[] args) throws IOException {
    
    // Configuration Object
    Configuration configuration = new Configuration();

    
    
    
    

    // Set path to the acoustic model.
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    
    // Set path to the dictionary.
    String DICTIONARY_PATH = VoiceLauncher.class.getResource("/2457.dic").toString();
    configuration.setDictionaryPath(DICTIONARY_PATH);
    
    // Set path to the language model.
    String LANGUAGE_MODEL_PATH = VoiceLauncher.class.getResource("/2457.lm").toString();
    configuration.setLanguageModelPath(LANGUAGE_MODEL_PATH);

    // Recognizer Object, Pass the Configuration object
    LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);

    // Start Recognition Process (The boolean parameter clears the previous cache if true)
    recognize.startRecognition(true);

    // Create SpeechResult Object
    SpeechResult result;
    
    // create process to start explorer.exe
    ProcessBuilder explorerProcess = new ProcessBuilder("explorer.exe");
    
    // create process to kill explorer
    ProcessBuilder killExplorerProcess = new ProcessBuilder("taskkill", "/f", "/im", "explorer.exe");
    
    // create process to kill explorer
    ProcessBuilder firefoxProcess = new ProcessBuilder("C:\\Program Files\\Mozilla Firefox\\firefox.exe");    
    
    // create process to kill explorer
    ProcessBuilder killFirefoxProcess = new ProcessBuilder("taskkill", "/f", "/im", "firefox.exe"); 

    // Checking if recognizer has recognized the speech
    while ((result = recognize.getResult()) != null) {
     
      // Get the recognize speech
      String command = result.getHypothesis();
      
      //Match recognized speech with our commands
      if(command.equalsIgnoreCase("open file manager")) {
        
        // execute the process
        explorerProcess.start() ;
          
        System.out.println("File Manager Opened!");

      } else if (command.equalsIgnoreCase("close file manager")) {
        
        killExplorerProcess.start();

        System.out.println("File Manager Closed!");
          
        
        // wait a second so finish executing the taskkill (it need's a moment to empty the cache)
        try {
          TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e) {
            
        }

        // restart explorer, otherwise your desktop will be gone
        explorerProcess.start();
          
      } else if (command.equalsIgnoreCase("open browser")) {
          
        // open firefox, that should take a few seconds
        firefoxProcess.start() ;
        
        System.out.println("FireFox Opened!");
      } else if (command.equalsIgnoreCase("close browser")) {
        
        killFirefoxProcess.start() ;
        
        System.out.println("FireFox Closed!");
        
      } else if (command.equalsIgnoreCase("exit program")) {
        System.out.println("Exiting Program! Bye!");
        break;
      }

    }

  }

}
