package teerayut.dev.vlife.profile.profile;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.profile.adapter.ProfileTabAdapter;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Alert;
import teerayut.dev.vlife.utils.Config;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    private View view;
    private Uri pictureUri;
    private ProfileTabAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.image_profile) CircleImageView imageView;
    @BindView(R.id.change_image) CircleImageView changeImage;
    @BindView(R.id.profile_name) TextView username;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.detail_tabs) TabLayout tabLayout;
    private void bindView() {
        ButterKnife.bind(this, view);
        setView();
    }

    private void setView() {
        username.setText(getResources().getString(R.string.username));
        setTabView();
        changeImage.setOnClickListener( onChangeImage() );
    }

    private void setTabView() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab1_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab2_title));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setFillViewport(true);
        adapter = new ProfileTabAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        ActivityResultBus.getInstance().register(mActivityResultSubscriber);
    }

    @Override
    public void onStop() {
        super.onStop();
        ActivityResultBus.getInstance().unregister(mActivityResultSubscriber);
    }

    private Object mActivityResultSubscriber = new Object() {
        @Subscribe
        public void onActivityResultReceived(ActivityResultEvent event) {
            int requestCode = event.getRequestCode();
            int resultCode = event.getResultCode();
            Intent data = event.getData();
            onActivityResult(requestCode, resultCode, data);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Config.REQUEST_GALLERY :
                if (resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                    Log.e("Gallery", selectedImage.toString());
                }
                break;
            case Config.REQUEST_CAMERA :
                if (resultCode == RESULT_OK){
                    /*Uri selectedImage = data.getData();*/
                    imageView.setImageURI(pictureUri);
                    //Log.e("Camera", data.getData().toString());


                }
                break;
            default:break;
        }
    }

    private View.OnClickListener onChangeImage() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        };
    }

    private void imageChooser() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        String path = Environment.getExternalStorageDirectory() + "/"+ now +".jpg";

        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(path);
        pictureUri = Uri.fromFile( file );
        takePicture.putExtra( MediaStore.EXTRA_OUTPUT, pictureUri );

        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        Alert.dialogChooser(getActivity(), R.string.dialog_title_chooser, R.string.dialog_choose_gallery_or_camera,
                R.string.dialog_btn_gallery, R.string.dialog_btn_camera, pickPhoto, Config.REQUEST_GALLERY, takePicture, Config.REQUEST_CAMERA);
    }
}
