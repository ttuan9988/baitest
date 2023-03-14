package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Joke jk;
    int sl=0;
    Cursor dataJoke;
    Random generator = new Random();
    ArrayList<Integer> j = new ArrayList<>();
    TextView textv;
    int b = 0;
    boolean a = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textv = (TextView) this.findViewById(R.id.text1) ;

        jk = new Joke(this, "Joke.sqlite", null, 1);
        jk.Querydata("CREATE TABLE IF NOT EXISTS TRUYEN(ID INTEGER PRIMARY KEY AUTOINCREMENT,CAUTRUYEN NVARCHAR(2000),fUN INTEGER,NOTFUN INTEGER)");
        dataJoke = jk.GetData("SELECT COUNT(*) FROM TRUYEN ");
        while (dataJoke.moveToNext()){
            if(dataJoke.getInt(0)==0){
                jk.Querydata("INSERT INTO TRUYEN VALUES(NULL,'A child asked his father, \"How were people born?\" So his father said, \"Adam and Eve made babies, then their babies became adults and made babies, and so on.\"  The child then went to his mother, asked her the same question and she told him, \"We were monkeys then we evolved to become like we are now.\"  The child ran back to his father and said, \"You lied to me!\" His father replied, \"No, your mom was talking about her side of the family.\"',0,0)");
                jk.Querydata("INSERT INTO TRUYEN VALUES(NULL,'Teacher: \"Kids,what does the chicken give you?\" Student: \"Meat!\" Teacher: \"Very good! Now what does the pig give you?\" Student: \"Bacon!\" Teacher: \"Great! And what does the fat cow give you?\" Student: \"Homework!\"',0,0)");
                jk.Querydata("INSERT INTO TRUYEN VALUES(NULL,'The teacher asked Jimmy, Why is your cat at school today Jimmy? Jimmy replied crying, Because I heard my daddy tell my mommy,I am going to eat that pussy once Jimmy leaves for school today!',0,0)");
                jk.Querydata("INSERT INTO TRUYEN VALUES(NULL,'A housewife, an accountant and a lawyer were asked How much is 2+2? The housewife replies: Four!. The accountant says: I think it's either 3 or 4.  Let me run those figures through my spreadsheet one more time. The lawyer pulls the drapes, dims the lights and asks in a hushed voice, How much do you want it to be?',0,0)");
            }
            else {
                sl=dataJoke.getInt(0);
            }
        }
        dataJoke = jk.GetData("SELECT * FROM TRUYEN;");
        while (dataJoke.moveToNext()){
                int id = dataJoke.getInt(0);
                j.add(id);
                b= dataJoke.getInt(2);
                textv.setText(dataJoke.getString(1));
                break;
        }
    }
    public void notfun(View view) {
        if(a==false){
            int f = b++;
            a= true;
            jk.Querydata("UPDATE TRUYEN SET NOTfUN = '"+f+"' WHERE ID = '"+dataJoke.getInt(0)+"';");
            dataJoke = jk.GetData("SELECT * FROM TRUYEN;");
            while (dataJoke.moveToNext()){
                if(!j.contains(dataJoke.getInt(0))){
                    int id = dataJoke.getInt(0);
                    j.add(id);
                    textv.setText(dataJoke.getString(1));
                    break;
                }
            }
        }else {
            if(sl==0){
                textv.setText("That's all the jokes for today! Come back another day!");
            }else if(j.size()<sl){
                dataJoke = jk.GetData("SELECT * FROM TRUYEN;");
                while (dataJoke.moveToNext()){
                    if(!j.contains(dataJoke.getInt(0))){
                        int id = dataJoke.getInt(0);
                        j.add(id);
                        textv.setText(dataJoke.getString(1));
                        int f = dataJoke.getInt(3)+1;
                        jk.Querydata("UPDATE TRUYEN SET fUN = '"+f+"' WHERE ID = '"+dataJoke.getInt(0)+"';");
                        break;
                    }
                }
            }else {
                textv.setText("That's all the jokes for today! Come back another day!");
            }
        }

    }
    public void fun(View view) {
        if(a==false){
            int f = b++;
            a= true;
            jk.Querydata("UPDATE TRUYEN SET fUN = '"+f+"' WHERE ID = '"+dataJoke.getInt(0)+"';");
            dataJoke = jk.GetData("SELECT * FROM TRUYEN;");
            while (dataJoke.moveToNext()){
                if(!j.contains(dataJoke.getInt(0))){
                    int id = dataJoke.getInt(0);
                    j.add(id);
                    textv.setText(dataJoke.getString(1));
                    break;
                }
            }
        }else {
            if(sl==0){
                textv.setText("That's all the jokes for today! Come back another day!");
            }else if(j.size()<sl){
                dataJoke = jk.GetData("SELECT * FROM TRUYEN;");
                while (dataJoke.moveToNext()){
                    if(!j.contains(dataJoke.getInt(0))){
                        int id = dataJoke.getInt(0);
                        j.add(id);
                        textv.setText(dataJoke.getString(1));
                        int f = dataJoke.getInt(3)+1;
                        jk.Querydata("UPDATE TRUYEN SET fUN = '"+f+"' WHERE ID = '"+dataJoke.getInt(0)+"';");
                        break;
                    }
                }
            }else {
                textv.setText("That's all the jokes for today! Come back another day!");
            }
        }
    }
}