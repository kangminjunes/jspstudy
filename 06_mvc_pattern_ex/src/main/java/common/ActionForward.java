package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActionForward {
  private String path;
  private boolean isRedirect; // redirect로 만들어도 같은 get,set생성함
}
