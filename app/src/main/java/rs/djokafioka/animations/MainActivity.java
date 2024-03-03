package rs.djokafioka.animations;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private ImageView mImgLogo;
    private ImageView mImgOmniMobile;
    private ImageView mImgOmniWMS;
    private ImageView mImgOmniDev;
    private ImageView mImgOmniPa;
    private ImageView mImgOmniSms;
    private ImageView mImgOmniBi;
    private MediaPlayer mPlayer;

    Handler finishActivity = new Handler();
    Handler playTada = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finishActivity.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //Do any action here. Now we are moving to next page
                Intent startApp = new Intent(MainActivity.this, AppActivity.class);
                startActivity(startApp);
                /* This 'finish()' is for exiting the app when back button pressed
                 *  from MainAcitivity Home Fragment
                 */
                finish();
            }
        }, 7000);

//        playTada.postDelayed(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                //Do any action here. Now we are moving to next page
//                playTadaSound();
//            }
//        }, 2500);

        mImgLogo = (ImageView) findViewById(R.id.img_logo);
        mImgOmniMobile = (ImageView) findViewById(R.id.img_omnimobile);
        mImgOmniWMS = (ImageView) findViewById(R.id.img_omniwms);
        mImgOmniDev = (ImageView) findViewById(R.id.img_omnidev);
        mImgOmniPa = (ImageView) findViewById(R.id.img_omnipa);
        mImgOmniSms = (ImageView) findViewById(R.id.img_omnisms);
        mImgOmniBi = (ImageView) findViewById(R.id.img_omnibi);

        mImgLogo.setVisibility(View.INVISIBLE);
        mImgOmniMobile.setVisibility(View.INVISIBLE);
        mImgOmniWMS.setVisibility(View.INVISIBLE);
        mImgOmniDev.setVisibility(View.INVISIBLE);
        mImgOmniPa.setVisibility(View.INVISIBLE);
        mImgOmniSms.setVisibility(View.INVISIBLE);
        mImgOmniBi.setVisibility(View.INVISIBLE);

        Animation animationOmniMobile = AnimationUtils.loadAnimation(this, R.anim.slide_to_right);
        final Animation animationOmniWms = AnimationUtils.loadAnimation(this, R.anim.slide_to_left);
        final Animation animationOmniDev = AnimationUtils.loadAnimation(this, R.anim.slide_to_right);
        final Animation animationOmniPa = AnimationUtils.loadAnimation(this, R.anim.slide_to_left);
        final Animation animationOmniSms = AnimationUtils.loadAnimation(this, R.anim.slide_to_right);
        final Animation animationOmniBi = AnimationUtils.loadAnimation(this, R.anim.slide_to_left);
        final Animation animationLogo = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        animationOmniMobile.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniMobile.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgOmniWMS.startAnimation(animationOmniWms);
                stopPlayer();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationOmniWms.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniWMS.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgOmniDev.startAnimation(animationOmniDev);
                stopPlayer();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationOmniDev.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniDev.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgOmniPa.startAnimation(animationOmniPa);
                stopPlayer();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationOmniPa.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniPa.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgOmniSms.startAnimation(animationOmniSms);
                stopPlayer();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationOmniSms.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniSms.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgOmniBi.startAnimation(animationOmniBi);
                stopPlayer();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationOmniBi.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgOmniBi.setVisibility(View.VISIBLE);
                playSwishSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                mImgLogo.startAnimation(animationLogo);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        animationLogo.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {
                mImgLogo.setVisibility(View.VISIBLE);
                //playTadaSound();
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mImgOmniMobile.startAnimation(animationOmniMobile);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
//        ObjectAnimator animatorPantheonAlpha = ObjectAnimator.ofFloat(mImgOmniMobile, View.ALPHA, 0.0f, 1.0f);
//        ObjectAnimator animatorPantheon2Alpha = ObjectAnimator.ofFloat(mImgOmniWMS, View.ALPHA, 0.0f, 1.0f);
//        ObjectAnimator animatorPantheon = ObjectAnimator.ofFloat(mImgOmniMobile, "x", -1000f, getScreenWidth()/2f - (float) mPantheonWidth / 2);
//        ObjectAnimator animatorPantheon2 = ObjectAnimator.ofFloat(mImgOmniWMS, "x", 1000, getScreenWidth()/2f - (float) mPantheon2Width / 2);
//        animatorPantheon.setDuration(DURATION);
//        animatorPantheon2.setDuration(DURATION);
//        AnimatorSet animatorSetPantheon = new AnimatorSet();
//        animatorSetPantheon.playTogether(animatorPantheonAlpha, animatorPantheon);
//
//        AnimatorSet animatorSetPantheon2 = new AnimatorSet();
//        animatorSetPantheon2.playTogether(animatorPantheon2Alpha, animatorPantheon2);
//
//        AnimatorSet animatorSet2 = new AnimatorSet();
//        animatorSet2.playSequentially(animatorSetPantheon, animatorSetPantheon2);
//        if (!mIsAnmiated)
//        {
//            animatorSet2.start();
//            mIsAnmiated = true;
//        }

//        AnimatorSet slideToLeft = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
//                R.animator.slide_to_left);
//
//        AnimatorSet slideToRight = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,
//                R.animator.slide_to_right);
//
//        slideToRight.setTarget(mImgOmniMobile);
//        slideToLeft.setTarget(mImgOmniWMS);
//
//        AnimatorSet animatorSet3 = new AnimatorSet();
//        animatorSet3.playSequentially(slideToRight, slideToLeft);
//        if (!mIsAnmiated)
//        {
//            animatorSet3.start();
//            mIsAnmiated = true;
//        }

    }

    private int getScreenWidth()
    {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    private void playSwishSound()
    {
        playSound(R.raw.swish);
    }

    private void playTadaSound()
    {
        playSound(R.raw.tada);
    }

    private void playSound(int soundId)
    {
        if (mPlayer == null)
        {
            mPlayer = MediaPlayer.create(this, soundId);
        }

        try
        {
            if (mPlayer.isPlaying())
            {
                stopPlayer();
                mPlayer = MediaPlayer.create(this, soundId);
            }

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mp)
                {
                    stopPlayer();
                }
            });

            mPlayer.start();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void stopPlayer()
    {
        if (mPlayer != null)
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        stopPlayer();
        if (finishActivity != null)
            finishActivity.removeCallbacksAndMessages(null);

        if (playTada != null)
            playTada.removeCallbacksAndMessages(null);
    }
}
