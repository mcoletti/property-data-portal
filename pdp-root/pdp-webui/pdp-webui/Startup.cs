using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(pdp_webui.Startup))]
namespace pdp_webui
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
