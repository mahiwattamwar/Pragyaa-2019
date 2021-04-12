package org.maheshpragyaaa.pragyaa2021;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class ContactUsActivity extends AppCompatActivity {

    private Typeface fireFont;
    private ShimmerTextView sec2, sc1, hs2, ea2, fc1, fs1, wc1, pr2, spons2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle("COMMITTEES");
        toolbar1.setNavigationIcon(R.drawable.ic_arrow_black_24dp);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        sec2=findViewById(R.id.sec2);
        sc1=findViewById(R.id.sc1);
        hs2=findViewById(R.id.hs2);
        ea2=findViewById(R.id.ea2);
        fc1=findViewById(R.id.fc2);
        fs1=findViewById(R.id.fs2);
        wc1=findViewById(R.id.wc2);
        pr2=findViewById(R.id.pr2);
        spons2=findViewById(R.id.spons2);

        Shimmer shimmer = new Shimmer();
        shimmer.setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
        shimmer.setDuration(2000);
        Shimmer shimmer1 = new Shimmer();
        shimmer1.setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
        shimmer1.setDuration(3000);
        fireFont = Typeface.createFromAsset(getAssets(), "fonts/batmanforeveralternate.ttf");
        sec2.setTypeface(fireFont);
        shimmer.start(sec2);
        sc1.setTypeface(fireFont);
        shimmer.start(sc1);
        hs2.setTypeface(fireFont);
        shimmer.start(hs2);
        ea2.setTypeface(fireFont);
        shimmer.start(ea2);
        fc1.setTypeface(fireFont);
        shimmer.start(fc1);
        fs1.setTypeface(fireFont);
        shimmer.start(fs1);
        wc1.setTypeface(fireFont);
        shimmer.start(wc1);
        pr2.setTypeface(fireFont);
        shimmer.start(pr2);
        spons2.setTypeface(fireFont);
        shimmer.start(spons2);
        sec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Mr.Shubham Ghoti \n (Technical Secretary)\n Mo:- 9112335388");
                startActivity(ts);
            }
        });

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile"," STUDENT COORDINATOR'S\n\n Mr.Yash kala \n (Student Coordinator)\nMo:- 7020753498 \n\n Mr.Mangesh Kale\n (Student Coordinator) \n Mo: 9834019402 \n\n Ms.Aditi Kadam\n (Student Coordinator)");
                startActivity(ts);
            }
        });

        ea2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Event Affairs Committee\n\n Ms.Pooja Wadekar\n (Main Coordinator) \n\n Ms.Suruchi Walthare\n (Joint Coordinator) \n\n Mr.Ayush Rane\n (Joint Coordinator) \n Mo: 7385570289\n\n Mr.Omkar Bele \n (Joint Coordinator) \n Mo:- 8421385993 \n\n Ms.Mukta Silodkar\n (Joint Coordinator)  \n\n Ms.Pratiksha Munde\n (Joint Coordinator)");
                startActivity(ts);
            }
        });

        hs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile"," Hospitality, Guest Management and Lecture Series\n\nMs.Aanchal Dhawale \n (Main Coordinator) \n\n Mr.Jasraj Singh Bhosiwale \n (Main Coordinator)\n Mo:- 9764135554 \n\n  Ms.Sakshi Sabu\n (Joint Coordinator)  \n\nMs.Aarya Wadje\n (Joint Coordinator) \n\n Mr.Abhay Yemekar \n (Joint Coordinator) \n Mo:- 9579065125 \n\n Mr.Hemant Sajjan\n (Joint Coordinator)\n Mo: 8855831445 \n\n Ms.Swarnim Mishra\n (Joint Coordinator) ");
                startActivity(ts);
            }
        });

        fc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile"," Finance Committee\n\nMr.Mohit Pethe\n (Main Coordinator)\n Mo:- 7038982479\n\n Ms.Sarvesha Bhatgare\n (Joint Coordinator)\n\n  Mr.Saurabh Pachghare\n (Joint Coordinator) \n Mo:- 7841983268 \n\n Mr.Anirudha Welukar\n (Joint Coordinator)\n Mo: 9175529809 \n\n Mr.Aditya Bhosale\n (Joint Coordinator) \n Mo: 8080171512");
                startActivity(ts);
            }
        });

        fs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Food & Site Committee\n\nMr.Harsh Chandak\n (Main Coordinator) \n Mo:- 7410106545 \n\n Mr.Sahil Sharma \n (Joint Coordinator) \n Mo:- 6005729957 \n\n Mr.Rameshwar Pantamwar\n (Joint Coordinator) \n Mo:- 8624010455 \n\n Mr.Jayesh Sonale\n (Joint Coordinator) \n Mo: 8208232498 \n\n Ms.Nikita Wadje\n (Joint Coordinator) \n\n Mr.Shrikant Gavte\n (Joint Coordinator)\n Mo: 800775815");
                startActivity(ts);
            }
        });

        wc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Website, Advertisement and Multimedia Committee\n\nMr.Rushikesh Suradkar\n (Main Coordinator) \n Mo:- 9623319036\n\n Ms.Vaishnavi Bhagat\n (Main Coordinator)\n\n Mr. Mahesh Wattamwar\n (Joint Coordinator) \n Mo:- 7218232383 \n\n Ms.Anushka Patil\n (Joint Coordinator)  \n\n Mr.Abhijeet Shinde \n (Joint Coordinator) \n Mo: 9158170083 \n\n Mr.Atharva Mehetre\n (Joint Coordinator) \n Mo: 8847745335\n\n Mr.Chaitanya Shinde\n (Joint Coordinator) \n Mo:- 7758885106 \n\n  Mr. Onkar Patil\n (Joint Coordinator) \n Mo:- 91122335388 ");
                startActivity(ts);
            }
        });
        pr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Public Relations Committee\n\nMs.Vaishnavi Torkad\n (Main Coordinator)  \n\n Mr.Farhan Farooqui\n (Joint Coordinator)\n Mo: 9970876790 \n\n Mr.Hitesh Koli\n (Joint Coordinator)\n Mo: 9075706930\n\n Mr.Kapil Kale\n (Joint Coordinator) \n Mo:- 7030444135 \n\n Mr.Prashant Govande\n (Joint Coordinator) \n Mo: 7972221898 \n\n Ms.Shivangi Katre\n (Joint Coordinator)");
                startActivity(ts);
            }
        });

        spons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ts = new Intent(ContactUsActivity.this,MobileActivity.class);
                ts.putExtra("mobile","Sponsorship committee\n\nMr.Yogesh Tabjula Krishnasai\n (Main Coordinator) \n Mo:- 9326340673 \n\n Mr.Pushkar Khawas\n (Joint Coordinator) \n Mo:- 7768860281 \n\n Ms.Samradnyi Deshpande\n (Joint Coordinator) \n\n Ms.Snehal Karade\n (Joint Coordinator) \n\n Mr.Tanmay Deshmukh\n (Joint Coordinator) \n Mo: 9767097542");
                startActivity(ts);
            }
        });


    }
}