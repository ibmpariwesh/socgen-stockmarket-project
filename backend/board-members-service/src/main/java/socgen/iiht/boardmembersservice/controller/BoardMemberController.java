package socgen.iiht.boardmembersservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.boardmembersservice.model.BoardMember;
import socgen.iiht.boardmembersservice.repository.BoardMemberRepo;
import socgen.iiht.boardmembersservice.service.BoardMemberService;

import java.util.List;

@RestController
@RequestMapping("/board-members")
public class BoardMemberController {
    @Autowired
    private BoardMemberService boardMemberService;
    @GetMapping("/get_all_board_members")
    public List<BoardMember> getAllBoardMembers(){
        return boardMemberService.getAllBoardMembers();
    }

    @PostMapping("/addBoardMember")
    public void addBoardMember(@RequestBody BoardMember boardMember){
        boardMemberService.addBoardMember(boardMember);
    }

    @DeleteMapping("/delete_board_member_by_id/{id}")
    public void deleteBoardMemberById(@PathVariable int id){
        boardMemberService.deleteBoardMemberById(id);
    }
}
