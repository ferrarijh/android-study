# Login/Register Activity
Simple app with login, register activity for studying passing data with intent, shared preference, startActivityForResult() & onActivityResult().

## SharedPreference
Stores data as xml file in /data/data/{<i>app_dir</i>}/shared_prefs/{<i>name</i>}.
Since the xml file is directly accessible, private information such as password should not be saved via shared preference.
However, just for the sake of studying I decided to try this.

## startActivityForResult(), onActivityResult()
<i>This api will be replaced with new api from google.
<br>https://developer.android.com/jetpack/androidx/releases/activity#version_120_2
<br>https://developer.android.com/jetpack/androidx/releases/fragment#version_130_2
</i>
<br>
Rather than simply starting another activity with ```startActivity(intent)```, an activity may summon another activity to expect certain result returned.
Such can be done with ```startActivityForResult(intent)```. The summoned activity sets result with ```setResult(RESULT_CODE, intent)``` and on ```finish()```,
the app returns to summoning activity. Summoning activity then decides what to do with the result inside body of ```onActivityResult()```.

## Demo
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/1.jpg" width="270" height="504">
</div>
LoginActivity. Calls RegisterActivity with startActivityForResult() when 'sign up' button is clicked. 
<br></br>
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/2.jpg" width="270" height="504">
</div>
Register Activity. When SUBMIT button is clicked Id and password will automatically be sent back to LoginActivity with function onActivityResult().
<br></br>
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/3.jpg" width="270" height="504">
</div>
As mentioned above id and password is automatically passed after registration. Clicking 'LOGIN' button leads to MainActivity.
<br></br>
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/4.jpg" width="270" height="504">
</div>
MainActivity.
<br></br>
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/5.jpg" width="270" height="570">
</div>
Even after the app is killed, login state will be recovered when the app is restarted through shared preference.
<br></br>
<div>
    <img src="https://github.com/ferrarijh/android-study-login/blob/master/demo/6.jpg" width="270" height="504">
</div>
As mentioned above, login state is restored.