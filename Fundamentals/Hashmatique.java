import java.util.Set;
import java.util.HashMap;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("TAVISTOCK GOOSEY FAIR.", "This famous song written for voice and piano by C J Trythall in 1912 shows how fond he was of the Devonshire scenes and characters.");
        trackList.put("EDDYSTONE LIGHT.", "A slightly ersatz ditty, but great fun. The Eddystone Lighthouse is fourteen miles off Plymouth. Glim means light.");
        trackList.put("WELCOME TO MORWELLHAM (IM)", "I wrote this extended piece to celebrate the success of the Morwellham Trust on reviving Morwellham Quay, near Tavistock, as a superb living monument to the past. If you haven`t been there... go!");
        trackList.put("TAVISTOCK RAMBLEAWAY.", "This radiant tune supports a fairly common story of seduction and its consequences, though related in some picturesque language.");
        // get the keys by using the keySet method
        System.out.println(trackList.get("TAVISTOCK RAMBLEAWAY."));

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println("---NAME: " + key);
            System.out.println("---DESCRIPTION: " + trackList.get(key));    
        }
    }
}