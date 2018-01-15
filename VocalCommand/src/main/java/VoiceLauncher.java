
//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

/**
 *
 * @author Abderrahim OUBIDAR
 */
public class VoiceLauncher {
  public static void main(String[] args) throws IOException {
    // Configuration Object
    Configuration configuration = new Configuration();

    String DICTIONARY_PATH = VoiceLauncher.class.getResource("/3112.dic").toString();
    
    String LANGUAGE_MODEL_PATH = VoiceLauncher.class.getResource("/3112.lm").toString();

    // Set path to the acoustic model.
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    // Set path to the dictionary.
    configuration.setDictionaryPath(DICTIONARY_PATH);
    // Set path to the language model.
    configuration.setLanguageModelPath(LANGUAGE_MODEL_PATH);

    // Recognizer Object, Pass the Configuration object
    LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);

    // Start Recognition Process (The bool parameter clears the previous cache if
    // true)
    recognize.startRecognition(true);

    // Create SpeechResult Object
    SpeechResult result;

    // Checking if recognizer has recognized the speech
    while ((result = recognize.getResult()) != null) {
     
      // Get the recognize speech
      String command = result.getHypothesis();
      String work = null;
      Process p;
      
      //Match recognized speech with our commands
      if(command.equalsIgnoreCase("open file manager")) {
          System.out.println("File Manager Opened!");
          work = "explorer.exe";
      } else if (command.equalsIgnoreCase("close file manager")) {
          System.out.println("File Manager Closed!");
          work = "exit explorer.exe";
      } else if (command.equalsIgnoreCase("open browser")) {
          System.out.println("Browser Opened!");
          work = "google-chrome";
      } else if (command.equalsIgnoreCase("close browser")) {
          System.out.println("Browser Closed!");
          work = "pkill google-chrome";
      }
      //In case command recognized is none of the above hence work might be null
      if(work != null) {
          //Execute the command
          p = Runtime.getRuntime().exec(work);
      }
    }

  }

}
