# paymobSDK

Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```

For newer versions of gradle add it to settings.gradle file

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Add the dependency:
```
dependencies {	
implementation 'com.github.samarammar:paymobSDK:0.1.0'
}
```

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Write in your onCreate() function:
```
new Checkout().startCheckout(MainActivity.this,String public key, integer amount of money);
```
put your account public key and the amount of money to pay

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

To add your own checkout Paymob Button
```
   <Button
        android:id="@+id/checkout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Checkout with"
        android:background="#0180FD"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:drawableEnd="@drawable/paymobcheckout"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

