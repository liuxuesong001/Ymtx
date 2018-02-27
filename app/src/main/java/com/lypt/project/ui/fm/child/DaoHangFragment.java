package com.lypt.project.ui.fm.child;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.lypt.project.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/28.
 */

public class DaoHangFragment extends CoreBaseFragment implements BDLocationListener,SensorEventListener {


    @BindView(R.id.bmapView)
    MapView mMapView;

    @BindView(R.id.rl_dw)
    RelativeLayout rlDw;

    private BaiduMap mBaiduMap;

    private BitmapDescriptor mCurrentMarker;

    private MyLocationConfiguration.LocationMode mCurrentMode;

    private MyLocationConfiguration config;

    private LocationClient mLocClient;

    // 是否首次定位
    private boolean isFirstLoc = true;

    private SensorManager mSensorManager;

    private Double lastX = 0.0;

    private int mCurrentDirection = 0;

    private double mCurrentLat = 0.0;

    private double mCurrentLon = 0.0;

    private float mCurrentAccracy;

    private MyLocationData locData;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_daohang;
    }



    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //开启交通图
        mBaiduMap.setBaiduHeatMapEnabled(true);
        //不显示缩放按钮
//        mMapView.showZoomControls(false);
        //是否显示比例尺
        mMapView.showScaleControl(false);
        //获取传感器管理服务
        mSensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        //定位模式 普通跟随罗盘
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        // 定位初始化
        mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(this);
        LocationClientOption option = new LocationClientOption();
        // 打开gps
        option.setOpenGps(true);
        // 设置坐标类型
        option.setCoorType("bd09ll");
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();







//
//        int iv = R.drawable.hd_rlt_icon;
//        Glide.with(this).load(iv).into(gif);
//        Glide.with(this).load(R.drawable.dh_gif).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gif);

//        LxBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                searchView.setVisibility(View.GONE);
//                LxBtn.setVisibility(View.GONE);
//                Glide.with(getActivity()).load(R.drawable.lx_gif).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(new GlideDrawableImageViewTarget(gif,1));
//                LxRl.setVisibility(View.VISIBLE);
////                Intent intent = new Intent(getActivity(), LXDHActivity.class);
////                getActivity().startActivity(intent);
//
//            }
//        });
//        dh_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                searchView.setVisibility(View.VISIBLE);
//                LxBtn.setVisibility(View.VISIBLE);
//                Glide.with(getActivity()).load(R.drawable.dh_gif).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gif);
//                LxRl.setVisibility(View.GONE);
//            }
//        });

    }

    @OnClick({R.id.rl_dw})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.rl_dw:
//                mBaiduMap.setOnMyLocationClickListener(new BaiduMap.OnMyLocationClickListener() {
//                    @Override
//                    public boolean onMyLocationClick() {
//                        return true;
//                    }
//                });
                double la=39.919852;
                double lt=116.403619;
                LatLng ll = new LatLng(la, lt);
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(17.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                break;
            default:
        }
    }


    @Override
    public void onDestroy() {
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        if (mBaiduMap!=null&&mMapView!=null)
        {
            mBaiduMap.setMyLocationEnabled(false);
            mMapView.onDestroy();
            mMapView = null;
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
    }


    @Override
    public void onReceiveLocation(BDLocation location) {

        double la=39.919852;
        double lt=116.403619;

        // map view 销毁后不在处理新接收的位置
        if (location == null || mMapView == null) {
            return;
        }
        //最大最小缩放
//        mBaiduMap.setMaxAndMinZoomLevel(18f,8f);
//        mCurrentLat = location.getLatitude();
//        mCurrentLon = location.getLongitude();
        mCurrentLat = la;
        mCurrentLon = lt;
        mCurrentAccracy = location.getRadius();
        // 构造定位数据
        locData = new MyLocationData.Builder()
                .accuracy(location.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(100)
//                .latitude(location.getLatitude())
//                .longitude(location.getLongitude())
                .latitude(la)
                .longitude(lt)
                .build();
//        116.403619,39.919852

        // 设置定位数据
        mBaiduMap.setMyLocationData(locData);
        // 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
//        mCurrentMarker = BitmapDescriptorFactory.fromResource(R.drawable.icon_geo);
        config = new MyLocationConfiguration(mCurrentMode, true, mCurrentMarker);

        if (isFirstLoc) {
            isFirstLoc = false;
//            LatLng ll = new LatLng(location.getLatitude(),
//                    location.getLongitude());
            LatLng ll = new LatLng(la, lt);
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(17.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }
        mBaiduMap.setMyLocationConfiguration(config);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double x = sensorEvent.values[SensorManager.DATA_X];
        if (Math.abs(x - lastX) > 1.0) {
            mCurrentDirection = (int) x;
            locData = new MyLocationData.Builder()
                    .accuracy(mCurrentAccracy)
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection)
                    .latitude(mCurrentLat)
                    .longitude(mCurrentLon).build();
            mBaiduMap.setMyLocationData(locData);
        }
        lastX = x;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}

