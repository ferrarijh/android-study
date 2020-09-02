# jonathan-study
Let's study android

## Login

### Clickable TextView
some_activity.xml 에서 아래 항목 추가?
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
때문에 위처럼 간략하게 리스너를 등록할 수 있다:)
(클릭되면 registerText.OnClickListener.onClick()이 실행됨)
<br>
[참고]자바8이상 에서도 아래처럼 람다로 줄일 수 있다.
```
lobginBtn.setOnClickListener( v -> {
    doSomething();
});
```