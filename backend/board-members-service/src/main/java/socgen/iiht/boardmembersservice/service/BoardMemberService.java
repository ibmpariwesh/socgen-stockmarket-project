package socgen.iiht.boardmembersservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.boardmembersservice.model.BoardMember;
import socgen.iiht.boardmembersservice.repository.BoardMemberRepo;

import java.util.List;

@Service
public class BoardMemberService {
    @Autowired
    private BoardMemberRepo boardMemberRepo;

    public List<BoardMember> getAllBoardMembers(){
        return boardMemberRepo.findAll();
    }

    public void addBoardMember(BoardMember boardMember){
        boardMemberRepo.save(boardMember);
    }

    public void deleteBoardMemberById(int id){
        boardMemberRepo.deleteBoardMemberById(id);
    }
}
