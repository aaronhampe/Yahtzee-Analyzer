import model.*;
import analyzer.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Pattern, Integer> statistics = new HashMap<>();
        PatternAnalyzer analyzer = new PatternAnalyzer();
        DiceRoll roll = new DiceRoll();
        
        int count = 0;
        
        while(count < 1000) {
            // 1. Alle fünf Würfel neu werfen
            roll.rollAll();
            
            // 2. Die nackten Zahlen holen
            int[] values = roll.getResultValues();
            
            // 3. Das Muster durch deinen Analyzer ermitteln lassen
            Pattern resultPattern = analyzer.evaluateThrow(values);
            
            // 4. In der Map hochzählen
            // getOrDefault holt den aktuellen Zählerstand (oder 0, falls noch nicht vorhanden) und wir addieren 1
            statistics.put(resultPattern, statistics.getOrDefault(resultPattern, 0) + 1);
            
            count++;    
        }

        // Ergebnis schön formatiert ausgeben
        System.out.println("--- Ergebnisse nach 1000 Würfen ---");
        for (Map.Entry<Pattern, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " mal");
        }
    }
}