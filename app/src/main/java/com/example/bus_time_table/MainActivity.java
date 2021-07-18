package com.example.bus_time_table;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.startapp.sdk.adsbase.StartAppAd;

public class MainActivity extends AppCompatActivity {

    private CardView time, refund, track, buspass, helpdesk;
    private InterstitialAd interstitialAd;
    private String TAG = "this";
    private InterstitialAdListener interstitialAdListener;
    private StartAppAd startAppAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudienceNetworkAds.initialize(this);
        fb_ads();

        time = findViewById(R.id.time);
        refund = findViewById(R.id.refund);
        track = findViewById(R.id.track);
        buspass = findViewById(R.id.buspass);
        helpdesk = findViewById(R.id.helpdesk);

        startAppAd = new StartAppAd(this);
        startAppAd.showAd(); // show the ad

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();

                } else {
                    startAppAd.showAd();
                }
                Intent intent = new Intent(MainActivity.this, Web.class);
                intent.putExtra("uri", "https://gsrtc.in/site/downloads/innerPages/busEnquiry.html");
                startActivity(intent);
//               ; // show the ad
            }
        });

        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();

                } else {
                    startAppAd.showAd();
                }
                Intent intent = new Intent(MainActivity.this, Web.class);
                intent.putExtra("uri", "http://mail1.gsrtc.in/helpdesk/open.php");
                startActivity(intent);

            }
        });


        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();

                } else {
                    startAppAd.showAd();
                }
                Intent intent = new Intent(MainActivity.this, Web.class);
                intent.putExtra("uri", "https://www.gsrtc.in/vehcleStatus/vehicleOnRoot.php");
                startActivity(intent);

            }
        });

        buspass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();

                } else {
                    startAppAd.showAd();
                }
                Intent intent = new Intent(MainActivity.this, Web.class);
                intent.putExtra("uri", "https://www.gsrtc.in/BUSPASS/preOnlinePassengerNewBusPassSystem.do?hiddenAction=PassengerNewBussPass");
                startActivity(intent);

            }
        });


        helpdesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();

                } else {
                    startAppAd.showAd();
                }
                Intent intent = new Intent(MainActivity.this, Web.class);
                intent.putExtra("uri", "https://gsrtc.in/site/downloads/innerPages/termsConditions.html");
                startActivity(intent);

            }
        });

    }

    void fb_ads() {
        interstitialAd = new InterstitialAd(this, "543193456862877_543194936862729  ");
        // Create listeners for the Interstitial Ad
        interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
    }

}