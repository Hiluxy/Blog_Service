# Blog_Service
## ResponseDTO

---

```java
public static <T> ResponseDto<T> success(T data) {
    return new ResponseDto<>(true, data, null);
  }
```

제너릭 프로그래밍을 위해 `<T>` 를 사용해서 `list타입`도 받을 수 있도록 한다.  (현업에서 많이 쓰임)

제너럭 메소드는 리턴타입 앞에 `<>`를 붙여야한다. (T를 쓴 이유: **클래스 설계시** 관례적으로 Type의 T를 붙임)

즉, `public static <T> ResponseDto<T> success(T data)` 에서 `<T>` 는 제너릭함수 선언시 앞에 붙여줘야 되는 것, 뒤에 있는 `ResponseDto<T>` 는 리턴타입이다. (타입파리머터 및 리턴 타입, 매개 타입을 타입 파라미터의 타입으로 기술하여 사용한다.)
