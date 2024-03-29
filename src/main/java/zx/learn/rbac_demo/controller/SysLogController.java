package zx.learn.rbac_demo.controller;


import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zx.learn.rbac_demo.annotation.SysLogs;
import zx.learn.rbac_demo.model.SysLog;
import zx.learn.rbac_demo.service.SysLogService;

@Controller
@RequestMapping("log")
public class SysLogController {

    @Autowired
    SysLogService service;


    @RequestMapping("listLogPage.html")
//    @SysLogs(name = "日志列表", type = "查询")
    public String listLog(@RequestParam(required = false, defaultValue = "1") int page,
                          @RequestParam(required = false, defaultValue = "10") int limit,
                          @RequestParam(required = false, defaultValue = "") String str,
                          Model model) {

        Page<SysLog> logPage = service.listSysLog(page, limit, str);
        int pageNum = logPage.getPages();

        model.addAttribute("logList", logPage);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("str", str);

        return "log/logList";

    }

    @RequestMapping("deleteLog")
    @SysLogs(name = "删除日志", type = "删除")
    public String deleteLog(@RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false, defaultValue = "10") int limit,
                            int id,
                            Model model) {
        service.deleteLog(id);
        return "redirect:/log/listLogPage.html?page=" + page + "&limit=" + limit;
    }


}
