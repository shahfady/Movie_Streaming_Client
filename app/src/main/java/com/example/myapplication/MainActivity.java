package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.adapter.BannerMoviesPagerAdapter;
import com.example.myapplication.adapter.MainRecyclerAdapter;
import com.example.myapplication.model.AllCategory;
import com.example.myapplication.model.BannerMovies;
import com.example.myapplication.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    Timer slideTimer;
    Toolbar toolbar;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;

    List<AllCategory> allCategoryList;

    List<CategoryItem> homeCatListItem1 ;

    List<CategoryItem> homeCatListItem2 ;

    List<CategoryItem> homeCatListItem3 ;

    List<CategoryItem> homeCatListItem4 ;

    List<CategoryItem> homeCatListItem5 ;

    List<CategoryItem> homeCatListItem6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        //
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);


        homeBannerList = new ArrayList<>();

//        homeBannerList.add(new BannerMovies(1, "JUMANJI", "https://i.ytimg.com/vi/ljZ-zAAJZQ0/maxresdefault.jpg", "https://firebasestorage.googleapis.com/v0/b/lyriebird-f9317.appspot.com/o/JUMANJI_%20WELCOME%20TO%20THE%20JUNGLE%20-%20Official%20Trailer%20(HD).mp4?alt=media&token=7e93194a-f9ff-4f20-ba80-5dc6cb0fe21a&_gl=1*12erfl8*_ga*ODYwODQyMzgyLjE2ODY0MDIyOTM.*_ga_CW55HF8NVT*MTY4NjQ0OTAxMS4zLjEuMTY4NjQ0OTM4NS4wLjAuMA..mp4"));
//        homeBannerList.add(new BannerMovies(2, "PIKACHU", "https://static-koimoi.akamaized.net/wp-content/new-galleries/2019/05/pokemon-detective-pikachu-movie-review-1.jpg", " "));
//        homeBannerList.add(new BannerMovies(3, "Spiderman No Way Home", "https://cdn.theatlantic.com/thumbor/3BMOpGl7nKWxNEa8n-aUYlNXmmw=/0x0:2500x1406/1600x900/media/img/mt/2021/12/DF_12080_rv2/original.jpg", " "));

        tvShowBannerList = new ArrayList<>();

//        tvShowBannerList.add(new BannerMovies(1, "SCOOP", "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202306/scoop_review-sixteen_nine.jpg?VersionId=k4dq.zAIwDeMZW3kcLh8wun9le.4dvBb&size=690:388.jpg", " "));
//        tvShowBannerList.add(new BannerMovies(2, "LUCIFER", "https://wallpapers.com/images/hd/handsome-devil-lucifer-ttebl8yk1owisgqk.jpg", " "));
//        tvShowBannerList.add(new BannerMovies(3, "THE 100", "https://upload.wikimedia.org/wikipedia/ar/archive/3/34/20170618010126%21The-100.jpg", " "));

        kidsBannerList = new ArrayList<>();
//        kidsBannerList.add(new BannerMovies(1, "PAPOY", "https://i.insider.com/5d23692721a86134c77a38c5?width=700.jpg", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"));
//        kidsBannerList.add(new BannerMovies(2, "TOM&Jerry", "https://www.theweek.in/content/dam/week/leisure/society/images/2018/3/17/tom-and-jerry.jpg.transform/schema-16x9/image.jpg", " "));
//        kidsBannerList.add(new BannerMovies(3, "LooneyTunes", "https://pics.filmaffinity.com/Looney_Tunes_TV_Series-292381073-large.jpg", " "));


        movieBannerList = new ArrayList<>();
//        movieBannerList.add(new BannerMovies(1, "ICEAGE", "https://upload.wikimedia.org/wikipedia/en/e/e3/Ice_Age_2_The_Meltdown_%28video_game%29.jpg", " "));
//        movieBannerList.add(new BannerMovies(2, "THOR", "https://cdn.suwalls.com/wallpapers/movies/thor-the-dark-world-25053-2880x1800.jpg", " "));
//        movieBannerList.add(new BannerMovies(3, "Avengers", "https://wallpapers.com/images/featured/vm16xv4a69smdauy.jpg", " "));

         homeCatListItem1 = new ArrayList<>();

        homeCatListItem2 = new ArrayList<>();

         homeCatListItem3 = new ArrayList<>();

         homeCatListItem4 = new ArrayList<>();

         homeCatListItem5 = new ArrayList<>();

       homeCatListItem6 = new ArrayList<>();




        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("videos");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int id2 = 1;
                kidsBannerList.clear();
                tvShowBannerList.clear();
                homeBannerList.clear();
                movieBannerList.clear();
                homeCatListItem1.clear();
                homeCatListItem2.clear();
                homeCatListItem3.clear();
                homeCatListItem4.clear();
                homeCatListItem5.clear();
                homeCatListItem6.clear();
                if (dataSnapshot.exists()) {
                    StringBuilder dataBuilder = new StringBuilder();

                    for (DataSnapshot nodeSnapshot : dataSnapshot.getChildren()) {
                        // Access the properties of each node
                        String category = nodeSnapshot.child("category").getValue(String.class);
                        String fileURL = nodeSnapshot.child("fileURL").getValue(String.class);
                        String id = nodeSnapshot.child("id").getValue(String.class);
                        String movieName = nodeSnapshot.child("movieName").getValue(String.class);
                        String videoSlide = nodeSnapshot.child("video_slide").getValue(String.class);
                        String video_thumb = nodeSnapshot.child("video_thumb").getValue(String.class);

                        int idt = 0;
                        if (videoSlide != null) {
                            switch (videoSlide) {
                                case "Kids":
                                    kidsBannerList.add(new BannerMovies(idt, movieName, video_thumb, fileURL));
                                    idt++;
                                    break;
                                case "TV Shows":
                                    tvShowBannerList.add(new BannerMovies(idt, movieName, video_thumb, fileURL));
                                    idt++;
                                    break;
                                case "Home":
                                    homeBannerList.add(new BannerMovies(idt, movieName, video_thumb, fileURL));
                                    idt++;
                                    break;
                                case "Movies":
                                    movieBannerList.add(new BannerMovies(idt, movieName, video_thumb, fileURL));
                                    idt++;
                                    break;
                            }
                        }

                        switch (category) {
                            case "Hollywood Movies":
                                id2 = 1;
                                homeCatListItem1.add(new CategoryItem(id2, movieName, video_thumb, fileURL));
                                id2++;
                                break;
                            case "Bollywood Movies":
                                homeCatListItem2.add(new CategoryItem(++idt, movieName, video_thumb, fileURL));
                                idt++;
                                break;
                            case "Sports":
                                homeCatListItem3.add(new CategoryItem(++idt, movieName, video_thumb, fileURL));
                                idt++;
                                break;
                            case "Romantic":
                                homeCatListItem4.add(new CategoryItem(++idt, movieName, video_thumb, fileURL));
                                idt++;
                                break;
                            case "Comedy":
                                homeCatListItem5.add(new CategoryItem(++idt, movieName, video_thumb, fileURL));
                                idt++;
                                break;
                            case "ScienceFiction":
                                homeCatListItem6.add(new CategoryItem(++idt, movieName, video_thumb, fileURL));
                                idt++;
                                break;
                        }
                        // Append the data to the StringBuilder
                        dataBuilder.append("Category: ").append(category).append("\n")
                                .append("File URL: ").append(fileURL).append("\n")
                                .append("ID: ").append(id).append("\n")
                                .append("Movie Name: ").append(movieName).append("\n")
                                .append("Video Slide: ").append(videoSlide).append("\n\n");
                    }

                    // Display the data in a toast
                    String data = dataBuilder.toString();
                } else {
                    // Handle the case when the data is not found
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
                }
                setBannerMoviesPagerAdapter(homeBannerList);

                allCategoryList = new ArrayList<>();
                allCategoryList.add(new AllCategory(1, "Hollywood Movies", homeCatListItem1));
                allCategoryList.add(new AllCategory(2, "Bollywood Movies", homeCatListItem2));
                allCategoryList.add(new AllCategory(3, "Sports", homeCatListItem3));
                allCategoryList.add(new AllCategory(4, "Romantic", homeCatListItem4));
                allCategoryList.add(new AllCategory(5, "Comedy", homeCatListItem5));
                allCategoryList.add(new AllCategory(6, "ScienceFiction", homeCatListItem6));


                setMainRecycler(allCategoryList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle the error
                Toast.makeText(getApplicationContext(), "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });


        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;

                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;

                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;

                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);

        // Create a new list to avoid modifying the original list
        List<BannerMovies> copyList = new ArrayList<>(bannerMoviesList);

        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, copyList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        slideTimer = new Timer();
        slideTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager, true);

        // Notify the adapter about the change
        bannerMoviesPagerAdapter.notifyDataSetChanged();
    }


    class AutoSlider extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int currentItem = bannerMoviesViewPager.getCurrentItem();
                    int totalCount = bannerMoviesViewPager.getAdapter().getCount();

                    if (currentItem < totalCount - 1) {
                        bannerMoviesViewPager.setCurrentItem(currentItem + 1, true);
                    } else {
                        bannerMoviesViewPager.setCurrentItem(0, true);
                    }
                }
            });
        }
    }



    public void setMainRecycler(List<AllCategory> allCategoryList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }


    private void setScrollDefaultState() {
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}