package com.iwalking11.myapplication;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends DialogFragment {



    public static BlankFragment newInstance(String versionCode, String description) {
        BlankFragment fragment = new BlankFragment();
        Bundle bundle = new Bundle();
//        bundle.putString("version", versionCode);
//        bundle.putString("description", description);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
//        mVersionCode = bundle.getString("version");
//        mDescription = bundle.getString("description");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, null);

        TextView versionTipText = (TextView) view.findViewById(R.id.version_tip_text);
        versionTipText.setText(String.format("版本发布"));
        TextView versionDescriptionText = (TextView) view.findViewById(R.id.version_description_text);
        versionDescriptionText.setText("发布新版本啦");

        Button button = (Button) view.findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        Window window = getDialog().getWindow();
        //必须要设置背景色，不然onstart方法中的宽度设置好后两边还是有一部分留边
        //随意设置一种颜色就行，因为我在fragment_blank.xml中已经设置背景色为#ffffff了
        //可以随意设置，但必须要设置
        window.setBackgroundDrawableResource(android.R.color.holo_purple);
        window.setGravity(Gravity.CENTER);
//        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_Dialog_Alert);
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(params);
        //在此处设置宽带无效，需到onStart方法中才行
//        Dialog dialog = getDialog();
//        if (dialog != null) {
//            DisplayMetrics dm = new DisplayMetrics();
//            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.75), ViewGroup.LayoutParams.WRAP_CONTENT);
//        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels*1), ViewGroup.LayoutParams.WRAP_CONTENT);
//            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
