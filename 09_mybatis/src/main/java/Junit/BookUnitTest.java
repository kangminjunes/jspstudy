  package Junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import domain.BookDto;
import repository.BookDao;

/*
 * 1. JUnit4 단위 테스트 수행 방법
 *   1) JUnit Test Case 파일 추가
 *   2) @Test 애너테이션 추가된 테스트 메소드 작성
 *   3) [Run As] - [JUnit Test]
 *   
 * 2. JUnit4 단위 테스트 주요 애너테이션
 *   1) @Test       : 실제 테스트 수행
 *   2) @Before     : @Test 이전에 수행
 *   3) @BeforeAll  : JUnit Test Case(BookUnitTest.java) 수행 이전, static 필수
 *   4) @After      : @Test 이후에 수행
 *   5) @AfterAll   : JUnit Test Case(BookUnitTest.java) 수행 이후, static 필수
 *   
 * 3. JUnit4 단위 테스트 주의사항
 *   1) 영속 계층(Dao)을 테스트 한다.
 *   2) WAS(Tomcat)의 개입이 없으므로 WAS가 필요한 코드는 테스트 불가하다.(일반적으로는 불가능하다는 의미)
 *   3) 메소드 이름을 한글로 작성해도 상관없다.
 *   
 * 4. 해당 @Test가 있어야 테스트 진행이 가능하다.
 */

public class BookUnitTest {

  // Dao
  private BookDao dao = BookDao.getDao();
  
    // @Test 
  public void 책_등록_테스트() {
    
    // 등록할 BookDto 생성
    BookDto dto = BookDto.builder()
                    .title("테스트제목임")
                    .author("테스트저자임")
                    .price(9999999)
                    .build();
    
    // BookDto 등록
    int addResult = dao.bookAdd(dto);
    
    // 등록 결과 확인
    assertEquals(1, addResult); // 앞에 적히는 건 기대값 뒤에는 실제로 나오는 결과값이다.
    
  }
  
  // @Test
  public void 책_조회_테스트() {
    
    // 조회할 책 번호
    int bookNo = 1;
    
    // 조회
    BookDto dto = dao.bookDetail(bookNo);
    
    // 조회 결과 확인
    assertNotNull(dto);
    
  }
  
  // @Test
  public void 책_목록_테스트() {
  
    // begin, end를 가진 Map 생성
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", 1);
    map.put("end", 20);
    
    // 목록 가져오기
    List<BookDto> list = dao.bookList(map);
    
    // 결과 확인
    assertEquals(1, list.size());
    
  }
  
  // @Test
  public void 책_수정_테스트() {
    
    // 수정할 BookDto 생성
    BookDto dto = BookDto.builder()
                    .bookNo(1)
                    .title("[수정]제목")
                    .author("[수정]저자")
                    .price(-999999)
                    .build();
  
   // 수정
    int moditfyResult = dao.bookModify(dto);
    
    // 결과 확인
    assertEquals(1, moditfyResult);
    
  
  }
  // @Test
  public void 책_삭제_테스트() {
    
    // 삭제할 책 번호
    int bookNo = 1;
    
    // 삭제
    int deleteResult = dao.bookDelete(bookNo);
    
    // 결과 확인
    assertEquals(1, deleteResult);
  }
  
}
