package oy.interact.tira.student;
import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {
    @Override
    public int compare (Coder first, Coder second){
        return first.getFullName().compareTo(second.getFullName());
    }
}
