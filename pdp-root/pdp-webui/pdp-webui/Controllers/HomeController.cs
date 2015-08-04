using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace pdp_webui.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        } 
        public ActionResult HowItWorks()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        } 
        public ActionResult Buyers()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }  
        
        public ActionResult Sellers()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        } 
        public ActionResult AgentsBrokers()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
        public ActionResult News()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
        public ActionResult Financing()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        } 
        public ActionResult PropertyManagers()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
        public ActionResult Insurance()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        } 
        public ActionResult IRAs()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
        public ActionResult Contractors()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}