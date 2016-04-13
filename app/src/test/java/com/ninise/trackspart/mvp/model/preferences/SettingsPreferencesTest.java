package com.ninise.trackspart.mvp.model.preferences;

import com.ninise.trackspart.BuildConfig;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SettingsPreferencesTest {

    private ShadowActivity mActivity = new ShadowActivity();

    private SettingsPreferences preferences;

    @Before
    public void setUp() {
        preferences = SettingsPreferences.getInstance(mActivity.getApplicationContext());
    }

    @Test
    public void testGetInstance() throws Exception {
        Assertions.assertThat(preferences).isNotNull();
    }

    @Test
    public void testSetSpinnerPosition() throws Exception {
        Assertions.assertThat(preferences.setSpinnerPosition(0)).isTrue();
    }

    @Test
    public void testGetSpinnerPosition() throws Exception {
        Assertions.assertThat(preferences.getSpinnerPosition()).isZero();
    }

    @Test
    public void testSetSaveLastCheckBox() throws Exception {
        Assertions.assertThat(preferences.setSaveLastCheckBox(true)).isTrue();
    }

    @Test
    public void testGetSaveLastCheckBox() throws Exception {
        Assertions.assertThat(preferences.getSaveLastCheckBox()).isFalse();
    }

    @Test
    public void testSetSetsCount() throws Exception {
        Assertions.assertThat(preferences.setSetsCount(1)).isTrue();
    }

    @Test
    public void testGetSetsCount() throws Exception {
        Assertions.assertThat(preferences.getSetsCount()).isEqualTo(0);
    }

    @Test
    public void testSetSecondsCount() throws Exception {
        Assertions.assertThat(preferences.setSecondsCount(1)).isTrue();
    }

    @Test
    public void testGetSecondsCount() throws Exception {
        Assertions.assertThat(preferences.getSecondsCount()).isEqualTo(1);
    }

    @Test
    public void testSetRestCount() throws Exception {
        Assertions.assertThat(preferences.setRestCount(1)).isTrue();
    }

    @Test
    public void testGetRestCount() throws Exception {
        Assertions.assertThat(preferences.getRestCount()).isEqualTo(0);
    }
}