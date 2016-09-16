package com.example.brunobraga.smarthome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brunobraga.smarthome.utils.CreateGroup;
import com.example.brunobraga.smarthome.utils.User;
import com.example.brunobraga.smarthome.utils.usefull;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private static final String TAG_QUERY = "QUERY DEBBUG";
    private FirebaseUser userRef;
    private LinearLayout oldLayout;
    private ListView addFriendslistView = null;
    private usefull useFull = new usefull();
    private ViewGroup cancelFriendsViewGroup;
    private ListView cancelFriendslistView;
    private ArrayAdapter<String> adapterCancelFriends;
    private View footerView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> addFriendsToListArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        oldLayout = (LinearLayout)findViewById(R.id.app_bar_main_screen_layout);
        cancelFriendsViewGroup = (ViewGroup)findViewById(R.id.createGroup);
        cancelFriendslistView = new ListView(mainScreen.this);
        mAuth = FirebaseAuth.getInstance();
        userRef = FirebaseAuth.getInstance().getCurrentUser();
        Button addFriendsToList = (Button)findViewById(R.id.addFriendsToList);

        if (userRef != null) {
            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("usersUid").child(userRef.getUid()+"/userInfo").addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get user value
                            final User user = dataSnapshot.getValue(User.class);
                            if(user.nickName == null){
                                setUpNickNamePopUp(user);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.w(TAG_QUERY, "getUser:onCancelled", databaseError.toException());
                            // ....
                        }
                    });


        } else {
            System.out.println("tem user logado nao");
        }
        FloatingActionButton fabCreateGroup = (FloatingActionButton) findViewById(R.id.fabCreateGroup);
        fabCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList friendsToAddOnGroup = new ArrayList();
                for(int i=0;i<useFull.selectedFriends.size();i++){
                    friendsToAddOnGroup.add(useFull.selectedFriends.get(i));
                }
                CreateGroup createGroup = new CreateGroup("bonde dos solteiro",friendsToAddOnGroup);
                mDatabase.child("groups").child("/bondeDosSolteiro").setValue(createGroup);

                Snackbar.make(view, "Group Created", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main_screen);

        TextView userName = (TextView) headerView.findViewById(R.id.userName);
        ImageView profilePicture = (ImageView) headerView.findViewById(R.id.profilePicture);

        userName.setText(userRef.getDisplayName());

        Uri profilePictureUri = Uri.parse(String.valueOf(userRef.getPhotoUrl()));
        Picasso.with(mainScreen.this).load(profilePictureUri).transform(new CircleTransform()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(profilePicture);

        addFriendslistView=new ListView(mainScreen.this);
        adapter=new ArrayAdapter<String>(mainScreen.this,R.layout.list_view_dialog, R.id.txtitem,addFriendsToListArray);
        addFriendslistView.setAdapter(adapter);
        footerView =  ((LayoutInflater)mainScreen.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.add_friends_edit_text, null, false);
        addFriendslistView.addFooterView(footerView);

        addFriendslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg=(ViewGroup)view;
                TextView txt = (TextView)vg.findViewById(R.id.txtitem);
                ImageView image = (ImageView)vg.findViewById(R.id.addFriendsToListImageView);
                Drawable background = txt.getBackground();
                if(image.getDrawable() == null){
                    Resources res = getResources(); // need this to fetch the drawable
                    Drawable draw = res.getDrawable( R.drawable.ic_done_black_24dp);
                    image.setImageDrawable(draw);
                }else {
                    image.setImageDrawable(null);
                }
                useFull.updateSelectedFriends(txt.getText().toString());
                Toast.makeText(mainScreen.this,txt.getText().toString(),Toast.LENGTH_LONG).show();
            }

        });

        //BUG ON THIS LISTENER, THIS LISTENER IS SUPPOSED TO REMOVE FRIENDS FROM THE ADDFRIENDSTOGROUP LIST, ALTHOUGH IT IS REMOVING, IT WONT ACTUALLY DELETE THE VIEWS
        cancelFriendslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewGroup vg=(ViewGroup)view;
                TextView txt=(TextView)vg.findViewById(R.id.usersNameOnAddFriends);
                useFull.selectedFriends.remove(txt.getText().toString());
                adapterCancelFriends.remove(txt.getText().toString());
                adapterCancelFriends.notifyDataSetChanged();
                cancelFriendslistView.setDivider(null);
                cancelFriendslistView.setDividerHeight(0);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setUpNickNamePopUp(final User user){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mainScreen.this);
        final EditText et = new EditText(mainScreen.this);
        alertDialogBuilder.setTitle("Welcome "+user.username);
        alertDialogBuilder.setMessage("Please Choose a Nick name");
        alertDialogBuilder.setView(et);
        alertDialogBuilder.create();

        alertDialogBuilder.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                DatabaseReference ref = mDatabase.child("/usersUid/"+user.userUid+"/userInfo");
                Map<String, Object> nickname = new HashMap<String, Object>();
                nickname.put("nickName",et.getText().toString());
                ref.updateChildren(nickname);

                Map<String, Object> usersNicknames = new HashMap<String, Object>();
                usersNicknames.put(et.getText().toString(),user.userUid);
                DatabaseReference refNickNames = mDatabase.child("nickNames");
                refNickNames.updateChildren(usersNicknames);
            }

        });
        alertDialogBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.navOverAll){
            LinearLayout v  = (LinearLayout) findViewById(R.id.app_bar_main_screen_layout);
            oldLayout.setVisibility(View.INVISIBLE);
            oldLayout = v;
            oldLayout.setVisibility(View.VISIBLE);
        }else if (id == R.id.navCreateGroup) {
            LinearLayout v  = (LinearLayout) findViewById(R.id.create_group_layout);
            oldLayout.setVisibility(View.INVISIBLE);
            oldLayout = v;
            oldLayout.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.navSettings) {

        } else if (id == R.id.navLogOut) {
            mAuth.signOut();
            LoginManager.getInstance().logOut();
            Intent intent = new Intent(mainScreen.this,loginScreen.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClick(View view) {
        System.out.println("entrou onclick");
        switch (view.getId()){
            case R.id.addFriendsToList:
            {
                EditText friendNameEditText = (EditText)footerView.findViewById(R.id.editTextAddFriendsToList);
                String friendName = friendNameEditText.getText().toString();
                //REGEX TO TEST NICKNAME;
                Toast.makeText(mainScreen.this,friendName,Toast.LENGTH_LONG).show();
                addFriendsToListArray.add(friendName);
                adapter.notifyDataSetChanged();
                break;
            }
            case R.id.addFriendsButton:{
                AlertDialog.Builder addFriendsPopUp=new AlertDialog.Builder(mainScreen.this);
                addFriendsPopUp.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        adapterCancelFriends =new ArrayAdapter<String>(mainScreen.this,R.layout.cancel_friends_list, R.id.usersNameOnAddFriends,useFull.selectedFriends);
                        cancelFriendslistView.setAdapter(adapterCancelFriends);;
                        cancelFriendsViewGroup.addView(cancelFriendslistView);
                    }

                });
                addFriendsPopUp.setView(addFriendslistView);
                AlertDialog addFriendsDialog= addFriendsPopUp.create();
                addFriendsDialog.show();
                break;
            }
            default:{
                break;
            }

        }
    }

}

