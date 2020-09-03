# jonathan-study
Let's study android

## Login

### Relative Layout is Legacy
구글 안드로이드 공식 문서에선 Relative Layout대신 Constraint Layout을 사용하길 권장하고있다.
<br>
https://developer.android.com/guide/topics/ui/layout/relative?hl=ko

### Getting result from other Activity
보통 쉽게는 StartActivityForResult() 와 onActivityResult() 콤보 사용.
<br>
(추후 다른 API로 대체될 예정. https://developer.android.com/training/basics/intents/result?hl=ko)

### SharedPreferences
MODE_PRIVATE : 해당 앱에서만
MODE_WORLD_READABLE
MODE_WORLD_WRITABLE

### Linear layout - weight
Linear Layout의 자식 뷰 속성에 layout_weight 항목 사용시, 수평형이면 layout_width="0dp" 설정하고 layout_weight 값만으로 뷰 비율 설정.

### Nested Layouts - 'Double Taxation'
Nested Layouts 사용시 성능 저하 주의.<br>
https://developer.android.com/topic/performance/rendering/optimizing-view-hierarchies

### Clickable TextView
some_activity.xml 에서 아래 항목 추가? - 이젠 자동으로 되기 때문에 안 해도 됨.
```
android:onClick="onClick"
android:clickable="true"
```

### Button.setOnClickListener 분석
loginBtn 눌렸을 때 실행할 콜백 블록은 아래와 같다.
```kotlin
loginBtn.setOnClickListener{    //it: View
    doSomething()
}
```
얼핏 보기엔 직관적인데 정확히 어떻게 이 문법이 가능한걸까? - 결론은 SAM(Single Abstract Method) Conversion 덕분.
<br>
<br>
위를 풀어서 쓰면,
```kotlin
loginBtn.setOnClickListener(View.OnClickListener{
    fun onClick(v: View){
        doSomething()
    }
})
```
VIew.OnClickListener 는 Functional Interface(추상 메소드가 1개)여서 그 자리 대신에 람다 함수를 전달할 수도 있다.
때문에 위처럼 간략하게 리스너를 등록할 수 있다 :)
<br>
(클릭되면 registerText.OnClickListener.onClick()이 실행됨)
<br>
<br>
[참고]자바8이상 에서도 아래처럼 람다로 줄일 수 있다.
```
lobginBtn.setOnClickListener( v -> {
    doSomething();
});
```