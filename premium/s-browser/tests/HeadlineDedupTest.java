import com.saurabhsvision.sbrowser.NewsQualityGate;
public final class HeadlineDedupTest {
    private static void same(String a,String p,String b,String q){
        if(!NewsQualityGate.headlineKey(a,p).equals(NewsQualityGate.headlineKey(b,q)))
            throw new AssertionError("Duplicate headline not detected");
    }
    public static void main(String[] args){
        same("India wins final - BBC","BBC","INDIA wins final! - Reuters","Reuters");
        same("राज्य में नई योजना।","", "राज्य में  नई योजना","");
        if(NewsQualityGate.headlineKey("India wins final","").equals(NewsQualityGate.headlineKey("India loses final","")))
            throw new AssertionError("Distinct headlines were merged");
        System.out.println("PASS headline deduplication");
    }
}
