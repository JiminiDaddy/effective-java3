package item50;

import java.util.Date;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/05/11
 * Time : 5:08 PM
 */

public class Period {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)  {
            throw new IllegalArgumentException(start + "(시작시간)가 " + end + "(종료시간) 보다 늦을 수 없습니다.");
        }
        //this.start = start;
        //this.end = end;
        // 방어적 복사본으로 생성한다.
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date start() {
        return new Date(start.getTime());
        //return start;
    }

    public Date end() {
        return new Date(end.getTime());
        //return end;
    }
}
