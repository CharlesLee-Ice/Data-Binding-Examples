package com.example.liqilin.databindingexample;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.liqilin.databindingexample.databinding.ActivityMainBinding;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);

        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUser = User.getOneUser(this);
        mBinding.setUser(mUser);

        mBinding.setHandlers(this);

        List<User> users = User.getUsers();
        mBinding.setUserList(users);

        mBinding.setIndex(users.size() - 1);

        mBinding.setPaddingLeft(100);
    }

    public void onFirstNameClick(View view) {
        Toast.makeText(this, "first name clicked", Toast.LENGTH_SHORT).show();

        mUser.setFirstName("Welcome");
    }

    public void onLastNameClick(View view) {
        Toast.makeText(this, "last name clicked", Toast.LENGTH_SHORT).show();

        mUser.setLastName("Thanks");
    }

    public boolean onLastNameLongClick(User user) {
        Toast.makeText(this, "last name: "+user.lastName+" long clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    @BindingAdapter(value={"imageUrl", "placeholder"}, requireAll=false)
    public static void setImageUrl(SimpleDraweeView imageView, String uri, Drawable placeHolder) {
        if (uri != null) {
            imageView.setImageURI(uri);
        } else {
            imageView.getHierarchy().setPlaceholderImage(placeHolder);
        }
    }
}
