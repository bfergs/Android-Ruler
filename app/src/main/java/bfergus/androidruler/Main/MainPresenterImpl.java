package bfergus.androidruler.Main;

import bfergus.androidruler.Utils.DeviceMetricsUtils;
import bfergus.androidruler.Utils.MeasurementUtils;

public class MainPresenterImpl implements MainPresenter{

    private MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    public void getTouchHorizontalLocation(Float touchEventx) {
        String inches = DeviceMetricsUtils.getTouchLocationString(touchEventx);
        convertInches(inches);
    }

    private void convertInches(String inches) {
        String cm = MeasurementUtils.convertInchesToCm(inches);
        String mm = MeasurementUtils.convertInchesToMM(inches);

        setMeasurementTextViews(inches, cm, mm);
    }

    private void setMeasurementTextViews(String inches, String cm, String mm) {
        view.setInchTextView(inches);
        view.setCmTextView(cm);
        view.setMmTextView(mm);
    }
}
