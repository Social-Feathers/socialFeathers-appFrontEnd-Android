package com.socialfeathers.app.ui.home;

import com.socialfeathers.app.CauseData;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    //TODO to be changed
    private MutableLiveData<List<CauseData>> titles;

    // ToDo: del
    String tempDets = "William Shakespeare (bapt. 26 April 1564 – 23 April 1616)[a] was an English playwright, poet, and actor, widely regarded as the greatest writer in the English language and the world's greatest dramatist.[2][3][4] He is often called England's national poet and the \"Bard of Avon\" (or simply \"the Bard\").[5][b] His extant works, including collaborations, consist of some 39 plays,[c] 154 sonnets, two long narrative poems, and a few other verses, some of uncertain authorship. His plays have been translated into every major living language and are performed more often than those of any other playwright.[7] They also continue to be studied and reinterpreted.\n" +
            "\n" +
            "Shakespeare was born and raised in Stratford-upon-Avon, Warwickshire. At the age of 18, he married Anne Hathaway, with whom he had three children: Susanna and twins Hamnet and Judith. Sometime between 1585 and 1592, he began a successful career in London as an actor, writer, and part-owner of a playing company called the Lord Chamberlain's Men, later known as the King's Men. At age 49 (around 1613), he appears to have retired to Stratford, where he died three years later. Few records of Shakespeare's private life survive; this has stimulated considerable speculation about such matters as his physical appearance, his sexuality, his religious beliefs, and whether the works attributed to him were written by others.[8][9][10]\n" +
            "\n" +
            "Shakespeare produced most of his known works between 1589 and 1613.[11][12][d] His early plays were primarily comedies and histories and are regarded as some of the best work produced in these genres. Until about 1608, he wrote mainly tragedies, among them Hamlet, Romeo and Juliet, Othello, King Lear, and Macbeth, all considered to be among the finest works in the English language.[2][3][4] In the last phase of his life, he wrote tragicomedies (also known as romances) and collaborated with other playwrights.\n" +
            "\n" +
            "Many of Shakespeare's plays were published in editions of varying quality and accuracy in his lifetime. However, in 1623, two fellow actors and friends of Shakespeare's, John Heminges and Henry Condell, published a more definitive text known as the First Folio, a posthumous collected edition of Shakespeare's dramatic works that included all but two of his plays.[13] The volume was prefaced with a poem by Ben Jonson, in which Jonson presciently hails Shakespeare in a now-famous quote as \"not of an age, but for all time\".";

    public HomeViewModel() {
        List<CauseData> titleList = new ArrayList();
        titleList.add(new CauseData("Abdul Mutakabbir","Tag 1","My cause Title_1","Flat No. 12, King Housing, Gandhi Nagar, Delhi.",tempDets,"26/3/2020","pic_4","pic_3"));
        titleList.add(new CauseData("Shahab","Tag 2","My cause Title_2","Flat No. 12, King Housing, Gandhi Nagar, Delhi.",tempDets,"29/2/2020","pic_2","pic_1"));
        titleList.add(new CauseData("Fahad","Tag 3","My cause Title_3","Flat No. 12, King Housing, Gandhi Nagar, Delhi.",tempDets,"19/3/2020","pic_2","pic_3"));
        titleList.add(new CauseData("Akbar","Tag 2","My cause Title_4","Flat No. 12, King Housing, Gandhi Nagar, Delhi.",tempDets,"22/1/2020","pic_4","pic_1"));
        titleList.add(new CauseData("Krishna","Tag 1","My cause Title_5","Flat No. 12, King Housing, Gandhi Nagar, Delhi.",tempDets,"01/2/2020","pic_4","pic_3"));

        titles = new MutableLiveData<>(titleList);
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }


//    public   LiveData<String> getText() {
//        return mText;
//    }

    public LiveData<List<CauseData>> getTitles(){
        return titles;
    }
}