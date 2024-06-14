package underStand.auth.impl;

import underStand.auth.SnsAuth;
import underStand.dto.MemberDTO;

public class NaverAuth implements SnsAuth {

    @Override
    public boolean login(MemberDTO member) {
        return true;
    }
}
