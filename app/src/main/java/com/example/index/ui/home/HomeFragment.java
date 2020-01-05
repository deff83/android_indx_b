package com.example.index.ui.home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.MotionEventCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.index.Config;
import com.example.index.Models.Enums.IsBid;
import com.example.index.Models.OfferList.OfferList_Responce;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.R;
import com.example.index.ui.component.MyBottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView_buyer, recyclerView_seller, recycle_tools;
    private TextView title_main_card;
    private ToolsAdapter toolsAdapter;
    private OfferListAdapter offerListAdapter_buy, offerListAdapter_sell;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //open main_content
        LinearLayout main_content = (LinearLayout) root.findViewById(R.id.main_content);
        MyBottomSheetBehavior bottomSheetBehavior = (MyBottomSheetBehavior) BottomSheetBehavior.from(main_content);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        int pxHeight = Math.round((displaymetrics.heightPixels / displaymetrics.density-56-135)*displaymetrics.density);


        Log.d(TAG, "onCreateView: "+pxHeight);
        Log.d(TAG, "onCreateView: "+displaymetrics.heightPixels);
        bottomSheetBehavior.setPeekHeight(pxHeight);



        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {



                if (i != BottomSheetBehavior.STATE_EXPANDED) {
                    homeViewModel.set_tools_timer();
                }else{
                    homeViewModel.cancel_tools_timer();
                }

                /*if (i == BottomSheetBehavior.STATE_DRAGGING) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }*/
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                // React to dragging events

            }


        });

        recycle_tools = root.findViewById(R.id.recycle_tools);

        homeViewModel.getTools_responceMutableLiveData().observe(this, new Observer<Tools_Responce>() {
            @Override
            public void onChanged(Tools_Responce tools_responce) {
                // создаем адаптер
                if (toolsAdapter==null) {
                    toolsAdapter = new ToolsAdapter(root.getContext(), tools_responce.getToolList());
                    recycle_tools.setAdapter(toolsAdapter);
                    toolsAdapter.setListenerTool(new ListenerTool() {
                        @Override
                        public void recyclerviewOnClick(int idCoin) {
                            homeViewModel.setTekCoin(idCoin);
                            homeViewModel.clear_OfferList();
                            Log.d(TAG, "recyclerviewOnClick: "+idCoin);
                        }
                    });
                }else{
                    toolsAdapter.dataChanged(tools_responce.getToolList());
                }

                // устанавливаем для списка адаптер
                // создаем адаптер
            }
        });






        recyclerView_buyer = (RecyclerView) root.findViewById(R.id.layout_buyer);
        recyclerView_seller = (RecyclerView) root.findViewById(R.id.layout_seller);

        //LinearLayoutManager offerLayoutManager1 = new LinearLayoutManager(getContext());
        //offerLayoutManager1.setSmoothScrollbarEnabled(true);
        //recyclerView_buyer.setLayoutManager(offerLayoutManager1);
        //recyclerView_buyer.setNestedScrollingEnabled(true);

       //LinearLayoutManager offerLayoutManager = new LinearLayoutManager(getContext());
        //offerLayoutManager.setSmoothScrollbarEnabled(true);
        //recyclerView_seller.setLayoutManager(offerLayoutManager);
        //recyclerView_seller.setNestedScrollingEnabled(true);

        /*NestedScrollView nestedScrollView = new NestedScrollView(getContext());
        nestedScrollView.addView(recyclerView_seller);*/


        title_main_card = (TextView)  root.findViewById(R.id.title_main_card);


        /*ScrollView scrollView = (ScrollView) root.findViewById(R.id.content_no);
        bottomSheetBehavior.setAllowUserDraggingFalse(scrollView);*/

        Config.COL = 50;

        //final TextView text_home_content = root.findViewById(R.id.text_home_content);
        homeViewModel.getOfferList_responceMutableLiveData().observe(this, new Observer<OfferList_Responce>() {
            @Override
            public void onChanged(OfferList_Responce offerList_responce) {

                title_main_card.setText(offerList_responce.getName()+"");

                if (offerListAdapter_buy==null) {
                    offerListAdapter_buy = new OfferListAdapter(root.getContext(), offerList_responce.get_offerIdsList(IsBid.BUY, Config.COL));
                    recyclerView_buyer.setAdapter(offerListAdapter_buy);
                }else{
                    offerListAdapter_buy.dataChanged(offerList_responce.get_offerIdsList(IsBid.BUY, Config.COL));
                }
                if (offerListAdapter_sell==null) {
                    offerListAdapter_sell = new OfferListAdapter(root.getContext(), offerList_responce.get_offerIdsList(IsBid.SELL, Config.COL));
                    recyclerView_seller.setAdapter(offerListAdapter_sell);
                }else{
                    offerListAdapter_sell.dataChanged(offerList_responce.get_offerIdsList(IsBid.SELL, Config.COL));
                }



            }
        });
        homeViewModel.set_offer_timer();


        return root;
    }

    @Override
    public void onDestroy() {
        homeViewModel.cancel_timer();
        super.onDestroy();
    }
}